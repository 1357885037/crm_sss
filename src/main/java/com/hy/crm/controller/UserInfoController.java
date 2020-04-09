package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Shangji;
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

//    用户周
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


    //    用户月
    @ResponseBody
    @RequestMapping("/usermoth.do")
    public AccountJson usermoth(AccountJson accountJson,UserInfo userInfo, @RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit){
        Page pageHelper= PageHelper.startPage(page,limit,true);
        List<UserInfo> list=new ArrayList<>();
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        //所有用户
        List<Users> list1=usersService.list(queryWrapper);
        for (Users users:list1){
            String name=users.getU_Name();
//            商机
            userInfo.setB_UsersumMeonkey( businessService.UsersumYMeonkey(users.getU_Id()));
            userInfo.setB_UsersumSMeonkey(businessService.UsersumSYMeonkey(users.getU_Id()));
//            新曾合同
            userInfo.setC_UsersumMeonkey(contractsService.UsersumYMeonkey(users.getU_Id()));
            userInfo.setC_UsersumSMeonkey(contractsService.UsersumSYMeonkey(users.getU_Id()));
//            成交合同
            userInfo.setC_UserfulfillsumMeonkey(contractsService.UserfulfillsumYMeonkey(users.getU_Id()));
            userInfo.setC_UserfulfillsumSMeonkey(contractsService.UserfulfillsumSYMeonkey(users.getU_Id()));
//            跟单
            userInfo.setW_UsersumMeonkey( withsService.UsersumYMeonkey(users.getU_Id()));
            userInfo.setW_UsersumSMeonkey(withsService.UsersumSYMeonkey(users.getU_Id()));

            userInfo.setUname(name);
            list.add(userInfo);
        }
        accountJson.setCount(list.size());
        accountJson.setData(list);
        accountJson.setCode(0);

        return accountJson;
    }

    //    用户季度
    @ResponseBody
    @RequestMapping("/userquarter.do")
    public AccountJson userquarter(AccountJson accountJson,UserInfo userInfo, @RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit){
        Page pageHelper= PageHelper.startPage(page,limit,true);
        List<UserInfo> list=new ArrayList<>();
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        //所有用户
        List<Users> list1=usersService.list(queryWrapper);
        for (Users users:list1){
            String name=users.getU_Name();
//            商机
            userInfo.setB_UsersumMeonkey( businessService.UsersumJdMeonkey(users.getU_Id()));
            userInfo.setB_UsersumSMeonkey(businessService.UsersumSJdMeonkey(users.getU_Id()));
//            新曾合同
            userInfo.setC_UsersumMeonkey(contractsService.UsersumJdMeonkey(users.getU_Id()));
            userInfo.setC_UsersumSMeonkey(contractsService.UsersumSJdMeonkey(users.getU_Id()));
//            成交合同
            userInfo.setC_UserfulfillsumMeonkey(contractsService.UserfulfillsumJdMeonkey(users.getU_Id()));
            userInfo.setC_UserfulfillsumSMeonkey(contractsService.UserfulfillsumSJdMeonkey(users.getU_Id()));
//            跟单
            userInfo.setW_UsersumMeonkey( withsService.UsersumJdMeonkey(users.getU_Id()));
            userInfo.setW_UsersumSMeonkey(withsService.UsersumSJdMeonkey(users.getU_Id()));

            userInfo.setUname(name);
            list.add(userInfo);
        }
        accountJson.setCount(list.size());
        accountJson.setData(list);
        accountJson.setCode(0);

        return accountJson;
    }

    //    用户年
    @ResponseBody
    @RequestMapping("/useryear.do")
    public AccountJson useryear(AccountJson accountJson,UserInfo userInfo, @RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit){
        Page pageHelper= PageHelper.startPage(page,limit,true);
        List<UserInfo> list=new ArrayList<>();
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        //所有用户
        List<Users> list1=usersService.list(queryWrapper);
        for (Users users:list1){
            String name=users.getU_Name();
//            商机
            userInfo.setB_UsersumMeonkey( businessService.UsersumNMeonkey(users.getU_Id()));
            userInfo.setB_UsersumSMeonkey(businessService.UsersumSNMeonkey(users.getU_Id()));
//            新曾合同
            userInfo.setC_UsersumMeonkey(contractsService.UsersumNMeonkey(users.getU_Id()));
            userInfo.setC_UsersumSMeonkey(contractsService.UsersumSNMeonkey(users.getU_Id()));
//            成交合同
            userInfo.setC_UserfulfillsumMeonkey(contractsService.UserfulfillsumNMeonkey(users.getU_Id()));
            userInfo.setC_UserfulfillsumSMeonkey(contractsService.UserfulfillsumSNMeonkey(users.getU_Id()));
//            跟单
            userInfo.setW_UsersumMeonkey( withsService.UsersumNMeonkey(users.getU_Id()));
            userInfo.setW_UsersumSMeonkey(withsService.UsersumSNMeonkey(users.getU_Id()));

            userInfo.setUname(name);
            list.add(userInfo);
        }
        accountJson.setCount(list.size());
        accountJson.setData(list);
        accountJson.setCode(0);

        return accountJson;
    }

    @ResponseBody
    @RequestMapping("/sumbusinessTJ.do")
    public AccountJson sumbusinessTJ(AccountJson accountJson){
        List<Shangji> list=new ArrayList<>();
        QueryWrapper<Business> queryWrappers=new QueryWrapper<>();
        Integer num=businessService.count(queryWrappers);
        String d=businessService.countMeonkey();
        Double bb=Double.valueOf(d);
        for (int i=1;i<=5;i++){

            if(i==1){
                Shangji shangji=new Shangji();
                shangji.setCount(num);
                shangji.setMonkey(Double.valueOf(d));
                shangji.setHjh("100%");
                shangji.setNkk("100%");
                list.add(shangji);
            }
            if(i==2){
                Shangji shangji=new Shangji();
                QueryWrapper<Business> queryWrapper=new QueryWrapper<>();
                queryWrapper.eq("b_code",2);
                Integer a=businessService.count(queryWrapper);

                  String b=businessService.codemonkey2();

                shangji.setCount(a);
                shangji.setMonkey(b==null?0.0:Double.valueOf(b));

                double c;
                    try {
                        c=num/shangji.getCount();
                    } catch (ArithmeticException e) {
                        c=0.0;
                    }
                double f;
                if(Double.valueOf(d)==0.0){
                    f=0.0;
                }else{
                    f=shangji.getMonkey()/bb;
                }
                shangji.setHjh(c+"%");
                shangji.setNkk(f+"%");
                list.add(shangji);
            }
            if(i==3){
                Shangji shangji=new Shangji();
                QueryWrapper<Business> queryWrapper=new QueryWrapper<>();
                queryWrapper.eq("b_code",3);
                Integer a=businessService.count(queryWrapper);
                String b=businessService.codemonkey2();

                shangji.setCount(a);
                shangji.setMonkey(b==null?0:Double.valueOf(b));

                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(Double.valueOf(d)==0.0){
                    f=0.0;
                }else{
                    f=shangji.getMonkey()/bb;
                }

                shangji.setHjh(c+"%");
                shangji.setNkk(f+"%");
                list.add(shangji);
                shangji.toString();
            }
            if(i==4){
                Shangji shangji=new Shangji();
                QueryWrapper<Business> queryWrapper=new QueryWrapper<>();
                queryWrapper.eq("b_code",4);
                Integer a=businessService.count(queryWrapper);
                String b=businessService.codemonkey2();

                shangji.setCount(a);
                shangji.setMonkey(b==null?0:Double.valueOf(b));

                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(Double.valueOf(d)==0.0){
                    f=0.0;
                }else{
                    f=shangji.getMonkey()/bb;
                }
                shangji.setHjh(c+"%");
                shangji.setNkk(f+"%");
                list.add(shangji);
                shangji.toString();
            }
            if(i==5){
                Shangji shangji=new Shangji();
                QueryWrapper<Business> queryWrapper=new QueryWrapper<>();
                queryWrapper.eq("b_code",5);
                Integer a=businessService.count(queryWrapper);
                String b=businessService.codemonkey2();

                shangji.setCount(a);
                shangji.setMonkey(b==null?0:Double.valueOf(b));

                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(Double.valueOf(d)==0.0){
                    f=0.0;
                }else{
                    f=shangji.getMonkey()/bb;
                }
                shangji.setHjh(c+"%");
                shangji.setNkk(f+"%");
                shangji.toString();
                list.add(shangji);
            }

        }
        accountJson.setCode(0);
        accountJson.setCount(5);
        accountJson.setData(list);
        for(Shangji shangji:list){
            System.out.println(shangji.toString()+"111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        }

        return accountJson;
    }


}
