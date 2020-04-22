package com.hy.crm.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.*;
import com.hy.crm.service.*;
import com.hy.crm.service.impl.LoginServiceImpl;
import com.mysql.jdbc.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RealmDemo extends AuthorizingRealm {

    @Autowired
    private ILoginService iLoginService;

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @Autowired
    private IUsersService iUsersService;

    @Autowired
    private IUsers_rolesService iUsersRolesService;

    @Autowired
    private IRolesService iRolesService;

    @Autowired
    private IUsers_jurisdictionsService iUsersJurisdictionsService;

    @Autowired
    private IJurisdictionsService iJurisdictionsService;
    @Autowired
    private IRoles_jurisdictionService iRolesJurisdictionService;

    @Override                   /*授权*/
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1.先拿到用户名
        Object object=principalCollection.getPrimaryPrincipal();
        System.out.println(object.toString()+"*******************************************************************");
        //2.根据用户查询数据库得到角色和权限

        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("u_name",object.toString());
        Users users=iUsersService.getOne(queryWrapper);

        //角色
        QueryWrapper<Users_roles> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.eq("u_id",users.getU_Id());
        List<Users_roles> usersRolesList=iUsersRolesService.list(queryWrapper1);

        Set<String> permission=new HashSet<>();
        for(Users_roles usersRoles:usersRolesList){
            QueryWrapper<Roles> queryWrapper2=new QueryWrapper<>();
            queryWrapper2.eq("r_id",usersRoles.getR_id());
            Roles roles=iRolesService.getOne(queryWrapper2);
            QueryWrapper<Roles_jurisdiction> queryWrapper3=new QueryWrapper<>();
            queryWrapper3.eq("r_id",roles.getR_id());
            List<Roles_jurisdiction> rolesJurisdictions=iRolesJurisdictionService.list(queryWrapper3);
            for(Roles_jurisdiction rolesJurisdiction:rolesJurisdictions) {
                QueryWrapper<Jurisdictions> queryWrapper4=new QueryWrapper<>();
                queryWrapper4.eq("j_id",rolesJurisdiction.getJ_id());
                Jurisdictions jurisdictions=iJurisdictionsService.getOne(queryWrapper4);
                if(jurisdictions.getJ_url()!=""&& !StringUtils.isNullOrEmpty(jurisdictions.getJ_url())){
                    permission.add(jurisdictions.getJ_url());
                }

            }

        }

        //权限


        QueryWrapper<Users_jurisdictions> queryWrapper3=new QueryWrapper<>();
        queryWrapper3.eq("u_id",users.getU_Id());
        List<Users_jurisdictions> usersJurisdictions=iUsersJurisdictionsService.list(queryWrapper3);

        for (Users_jurisdictions usersJurisdictions1:usersJurisdictions){
            QueryWrapper<Jurisdictions> queryWrapper2=new QueryWrapper<>();
            queryWrapper2.eq("j_id",usersJurisdictions1.getJ_id());
            Jurisdictions jurisdictions=iJurisdictionsService.getOne(queryWrapper2);
            if(jurisdictions.getJ_url()!=""&& !StringUtils.isNullOrEmpty(jurisdictions.getJ_url())){
                permission.add(jurisdictions.getJ_url());
            }
        }

        for (String s : permission) {
            System.out.println("权限：+++"+s);
        }


        //3.返回授权的信息类
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
//        authorizationInfo.setRoles(rolesset);
        authorizationInfo.addStringPermissions(permission);

        return authorizationInfo;
    }

    @Override                   /*认证*/
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //转换
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)authenticationToken;
        //从usernameToken获取username
        String username=usernamePasswordToken.getUsername();
        //从数据库中查询
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("u_name",username);
        Users users=loginServiceImpl.getOne(queryWrapper);
        if(users==null){
            throw new UnknownAccountException("此用户不存在");
        }
        //7.根据用户的情况，来构建AuthenticationInfo对象,通常使用的实现类为SimpleAuthenticationInfo
        // 以下信息是从数据库中获取的
        // 1)principal：认证的实体信息，可以是username，也可以是数据库表对应的用户的实体对象
         Object principal = users.getU_Name();
        // 2)credentials：密码
         Object credentials =users.getU_pass();
        // 3)realmName：当前realm对象的name，调用父类的getName()方法即可
         String realmName = getName();
        // 4)credentialsSalt盐值
         ByteSource credentialsSalt = ByteSource.Util.bytes(principal);//使用账号作为盐值
         SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,realmName);

         return authenticationInfo;
    }

}

