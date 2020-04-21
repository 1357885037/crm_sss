package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Users_roles;
import com.hy.crm.service.IUsers_rolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/crm/users-roles")
public class Users_rolesController {

    @Autowired
    private IUsers_rolesService usersRolesService;

    @RequestMapping("/upuserroles.do")
    public ModelAndView upuserroles(String[]  r_name,String u_Id,ModelAndView modelAndView){

        QueryWrapper<Users_roles> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("u_id",u_Id);
        usersRolesService.remove(queryWrapper);

        for (int i=0;i<r_name.length;i++){

            Users_roles usersRoles=new Users_roles();
            usersRoles.setU_id(u_Id);
            usersRoles.setR_id(r_name[i]);

            usersRolesService.save(usersRoles);

        }
        modelAndView.setViewName("/page/user/queryUsers.html");
        return modelAndView;
    }

}
