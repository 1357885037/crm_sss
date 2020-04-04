package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Users;
import com.hy.crm.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @ResponseBody
    @RequestMapping("/queryAllUser")
    public  List<Users>  queryAllUser(){
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        List<Users>  usersList=usersService.list(queryWrapper);
        return usersList;
    }

}

