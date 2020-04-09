package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crm.entity.UserInfo;
import com.hy.crm.entity.Users;
import com.hy.crm.service.IBusinessService;
import com.hy.crm.service.IContractsService;
import com.hy.crm.service.IUsersService;
import com.hy.crm.service.IWithsService;
import com.hy.crm.util.AccountJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/crm/userinfo")
public class UserInfoController {

    @Autowired
    private IBusinessService businessService;
    @Autowired
    private IWithsService withsService;
    @Autowired
    private IContractsService contractsService;
    @Autowired
    private IUsersService usersService;

    @ResponseBody
    @RequestMapping("/userweek.do")
    public AccountJson userweek(AccountJson accountJson,UserInfo userInfo, @RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit){
        Page pageHelper= PageHelper.startPage(page,limit,true);
        List<UserInfo> list=new ArrayList<>();
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        List<Users> list1=usersService.list(queryWrapper);
        for (Users users:list1){
            String name=users.getU_Name();
//            商机
            userInfo.setB_UsersumMeonkey( businessService.UsersumMeonkey(users.getU_Id()));
            userInfo.setB_UsersumSMeonkey(businessService.UsersumSMeonkey(users.getU_Id()));
//            新曾合同
            userInfo.setC_UsersumMeonkey(contractsService.UsersumMeonkey(users.getU_Id()));
            userInfo.setC_UsersumSMeonkey(contractsService.UsersumSMeonkey(users.getU_Id()));
//            成交合同
            userInfo.setC_UserfulfillsumMeonkey(contractsService.UserfulfillsumMeonkey(users.getU_Id()));
            userInfo.setC_UserfulfillsumSMeonkey(contractsService.UserfulfillsumSMeonkey(users.getU_Id()));
//            跟单
            userInfo.setW_UsersumMeonkey( withsService.UsersumMeonkey(users.getU_Id()));
            userInfo.setW_UsersumSMeonkey(withsService.UsersumSMeonkey(users.getU_Id()));

            userInfo.setUname(name);
            list.add(userInfo);
        }
        accountJson.setCount(list.size());
        accountJson.setData(list);
        accountJson.setCode(0);

        return accountJson;
    }




}
