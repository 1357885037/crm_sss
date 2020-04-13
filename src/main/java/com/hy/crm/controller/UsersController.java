package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crm.entity.Users;
import com.hy.crm.service.IUsersService;
import com.hy.crm.util.AccountJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping("/queryAllUser.do")
    public AccountJson queryAllUser(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit,Users users){
     System.out.println(users.toString()+"1111111111111111111111111111111111111111111111111111111111111111111111111");

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
        AccountJson accountJson=new AccountJson();
        accountJson.setCode(0);
        accountJson.setCount(usersList.size());
        accountJson.setData(usersList);
        return accountJson;
    }


    @RequestMapping("/delusers.do")
    public Integer delusers(String u_id){
        System.out.println(u_id+"12121212123132132165465464679879875646545678465487465465465498786465465");
        int num=200;
        Users users=new Users();
        users.setU_statu(1);
        try {
            usersService.saveOrUpdate(users);
        } catch (Exception e) {
            num=500;
        }
        return num;

    }

}

