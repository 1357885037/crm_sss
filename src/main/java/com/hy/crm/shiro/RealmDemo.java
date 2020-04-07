package com.hy.crm.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Users;
import com.hy.crm.service.impl.LoginServiceImpl;
import com.hy.crm.service.ILoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class RealmDemo extends AuthorizingRealm {

    @Autowired
    private ILoginService iLoginService;

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @Override                   /*授权*/
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
      /*  System.out.println("授权开始=====================》");
        //1.先拿到用户名
        Object object=principalCollection.getPrimaryPrincipal();
        System.out.println(object);
        //2.根据用户查询数据库得到角色和权限

        Set<String> roles =bookService.roles(object.toString());
       *//* Set<String> roles=new HashSet<String>();
        roles.add("admin");*//*

        //权限
        *//*Set<String> permission=new HashSet<String>();
        permission.add("update");
        permission.add("delete");*//*
        Set<String> permission=bookService.users_jurisdiction(object.toString());
        Set<String> users_jurisdiction=bookService.users_jurisdiction2(object.toString());
        permission.addAll(users_jurisdiction);
        System.out.println("======>><<<><?<<>><<><><><><><<>><<><><><<>><<>><<>>"+permission.size());
        //3.返回授权的信息类*/
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
       // authorizationInfo.setRoles(roles);
        //authorizationInfo.addStringPermissions(permission);


        return authorizationInfo;
    }

    @Override                   /*认证*/
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //转换
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)authenticationToken;
        //从usernameToken获取username
        String username=usernamePasswordToken.getUsername();
        System.out.println("=====>"+username);
        System.out.println("=====>"+usernamePasswordToken.getPassword());
        //从数据库中查询
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("u_name",username);
        Users users=loginServiceImpl.getOne(queryWrapper);
        System.out.println(users+"666666666666666");
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

         System.out.println("===============？？？？/**/"+credentialsSalt);
         SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,realmName);

         return authenticationInfo;
    }
}
