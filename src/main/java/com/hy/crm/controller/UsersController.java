package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crm.entity.*;
import com.hy.crm.service.*;
import com.hy.crm.util.AccountJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author TH
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/sanqi/users")
public class UsersController {

    @Autowired
    private IUsersService usersService;
    @Autowired
    private IUsers_rolesService usersRolesService;
    @Autowired
    private IRolesService rolesService;

    @Autowired
    private IJurisdictionsService jurisdictionsService;

    @Autowired
    private IUsers_jurisdictionsService users_jurisdictionsService;

    @ResponseBody
    @RequestMapping("/queryAllUser.do")
    public AccountJson queryAllUser(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit,Users users){

       Page pages= PageHelper.startPage(page,limit,true);
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        if(users.getU_Name()!=null&&users.getU_Name()!=""){
            queryWrapper.like("u_name",users.getU_Name());
        }
        if(users.getU_Realname()!=null&&users.getU_Realname()!=""){
            queryWrapper.like("u_realname",users.getU_Realname());
        }
        if(users.getU_Sex()!=null&&!users.getU_Sex().equals("")){
            queryWrapper.eq("u_sex",users.getU_Sex());
        }
        if(users.getU_Date()!=null&&!users.getU_Date().equals("")){
            queryWrapper.eq("u_date",users.getU_Date());
        }


        queryWrapper.eq("u_statu",0);
        List<Users>  usersList=usersService.list(queryWrapper);
        for (Users users1:usersList){
            QueryWrapper<Users_roles> queryWrapper1=new QueryWrapper<>();
            queryWrapper1.eq("u_id",users1.getU_Id());
           List<Users_roles> usersRolesList=usersRolesService.list(queryWrapper1);
            for (Users_roles usersRoles:usersRolesList){
                QueryWrapper<Roles> queryWrapper2=new QueryWrapper<>();
                queryWrapper2.eq("r_id",usersRoles.getR_id());
                List<Roles> rolesList=rolesService.list(queryWrapper2);
                for (Roles roles:rolesList){
                    if(users1.getU_roles()==null){
                        users1.setU_roles(roles.getR_name());
                    }else {
                        users1.setU_roles(users1.getU_roles() + "," + roles.getR_name());
                    }
                }

            }

        }

        AccountJson accountJson=new AccountJson();
        accountJson.setCode(0);
        accountJson.setCount(usersList.size());
        accountJson.setData(usersList);
        return accountJson;
    }

    @ResponseBody
    @RequestMapping("/queryuser.do")
    public  List<Users> queryuser(AccountJson accountJson){

        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("u_statu",0);
        List<Users> usersList=usersService.list(queryWrapper);

        return usersList;
    }


    @RequestMapping("/delusers.do")
    public Integer delusers(String u_id){
        int num=200;
        Users users=new Users();
        users.setU_Id(u_id);
        users.setU_statu(1);
        try {
            usersService.saveOrUpdate(users);
        } catch (Exception e) {
            num=500;
        }
        return num;

    }

    @RequestMapping("/userRoles.do")
    public  ModelAndView userRoles(String u_Id,ModelAndView modelAndView){

        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("u_statu",0);
        queryWrapper.eq("u_id",u_Id);
        Users  users=usersService.getOne(queryWrapper);

        QueryWrapper<Users_roles> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.eq("u_id",users.getU_Id());
        List<Users_roles> usersRolesList=usersRolesService.list(queryWrapper1);

        QueryWrapper<Roles> queryWrapper3=new QueryWrapper<>();
        List<Roles> rolesList=rolesService.list(queryWrapper3);

        for (Roles  roles:rolesList){
            for (Users_roles usersRoles:usersRolesList){
                if(roles.getR_id().equals(usersRoles.getR_id())){
                    roles.setStart(1);
                    break;
                }else{
                    roles.setStart(2);
                }

            }
        }

         modelAndView.addObject("users",users);
         modelAndView.addObject("rolesList",rolesList);
         modelAndView.setViewName("/page/user/roles.html");

        return modelAndView;
    }


    @RequestMapping("/userjurisdiction.do")
    public  ModelAndView userjurisdiction(String u_Id,ModelAndView modelAndView){

        QueryWrapper<Jurisdictions> queryWrapper=new QueryWrapper<>();
        queryWrapper.isNull("jur_jid");
        List<Jurisdictions> jurisdictionsList=jurisdictionsService.list(queryWrapper);

        for (Jurisdictions jurisdictions:jurisdictionsList){
            QueryWrapper<Jurisdictions> queryWrapper2=new QueryWrapper<>();
            queryWrapper2.eq("jur_jid",jurisdictions.getJ_id());
            List<Jurisdictions>  jurisdictions2=jurisdictionsService.list(queryWrapper2);
            jurisdictions.setJurisdictionsList(jurisdictions2);

        }

        QueryWrapper<Users_jurisdictions> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.eq("u_id",u_Id);
        List<Users_jurisdictions> rolesJurisdictions=users_jurisdictionsService.list(queryWrapper1);

        QueryWrapper<Users> queryWrapper2=new QueryWrapper<>();
        queryWrapper2.eq("u_id",u_Id);
        Users users=usersService.getOne(queryWrapper2);
        for (Jurisdictions jurisdictions:jurisdictionsList){
            for (Users_jurisdictions rolesJurisdiction:rolesJurisdictions){
                if(jurisdictions.getJ_id().equals(rolesJurisdiction.getJ_id())){
                    jurisdictions.setStatus(1);
                    break;
                }else{
                    jurisdictions.setStatus(2);
                }

            }

            for (Jurisdictions jurisdictions1:jurisdictions.getJurisdictionsList()){
                for (Users_jurisdictions rolesJurisdiction:rolesJurisdictions){
                    if(jurisdictions1.getJ_id().equals(rolesJurisdiction.getJ_id())){
                        jurisdictions1.setStatus(1);
                        break;
                    }else{
                        jurisdictions1.setStatus(2);
                    }

                }

            }

        }
        modelAndView.addObject("jurisdictionsList",jurisdictionsList);
        modelAndView.addObject("users",users);
        modelAndView.setViewName("/page/user/user_Right.html");

        return modelAndView;
    }


}

