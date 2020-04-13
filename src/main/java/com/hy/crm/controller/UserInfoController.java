package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crm.entity.*;
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
    public AccountJson userweek(AccountJson accountJson, @RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit){
        Page pageHelper= PageHelper.startPage(page,limit,true);
        List<UserInfo> list=new ArrayList<>();
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        List<Users> list1=usersService.list(queryWrapper);
        for (Users users:list1){
            UserInfo userInfo=new UserInfo();
            userInfo.setUname(users.getU_Name());

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
    public AccountJson usermoth(AccountJson accountJson, @RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit){
        Page pageHelper= PageHelper.startPage(page,limit,true);
        List<UserInfo> list=new ArrayList<>();
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        //所有用户
        List<Users> list1=usersService.list(queryWrapper);
        for (Users users:list1){
            UserInfo userInfo=new UserInfo();
            userInfo.setUname(users.getU_Name());
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
    public AccountJson userquarter(AccountJson accountJson, @RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit){
        Page pageHelper= PageHelper.startPage(page,limit,true);
        List<UserInfo> list=new ArrayList<>();
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        //所有用户
        List<Users> list1=usersService.list(queryWrapper);
        for (Users users:list1){
            UserInfo userInfo=new UserInfo();
            userInfo.setUname(users.getU_Name());
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
    public AccountJson useryear(AccountJson accountJson, @RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit){
        Page pageHelper= PageHelper.startPage(page,limit,true);
        List<UserInfo> list=new ArrayList<>();
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        //所有用户
        List<Users> list1=usersService.list(queryWrapper);
        for (Users users:list1){
            UserInfo userInfo=new UserInfo();
            userInfo.setUname(users.getU_Name());
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
        Double bb=0.0;
        if(businessService.codeJdmonkey1()=="null"||businessService.codeJdmonkey1()==null||businessService.codeJdmonkey1()==""){
            bb=0.0;
        }else{
            bb=Double.valueOf(d);
        }
        for (int i=1;i<=5;i++){

            if(i==1){
                Shangji shangji=new Shangji();
                shangji.setCount(num);
                shangji.setMonkey(bb);
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
                if(bb==0.0){
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
                if(bb==0.0){
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
                if(bb==0.0){
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
                if(bb==0.0){
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

//季度

    @RequestMapping("/sumbusinessJd.do")
    @ResponseBody
    public AccountJson sumbusinessJd(AccountJson accountJson){
        List<Shangji> list=new ArrayList<>();
        Integer num=businessService.codeJdRen1();
        String d=businessService.codeJdmonkey1();
        Double bb=0.0;
        if(businessService.codeJdmonkey1()=="null"||businessService.codeJdmonkey1()==null||businessService.codeJdmonkey1()==""){
            bb=0.0;
        }else{
            bb=Double.valueOf(d);
        }
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
                Integer a=businessService.codeJdRen2();

                String b=businessService.codeJdmonkey2();

                shangji.setCount(a);
                shangji.setMonkey(b==null?0.0:Double.valueOf(b));

                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(bb==0.0){
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
                Integer a=businessService.codeJdRen3();
                String b=businessService.codeJdmonkey3();
                shangji.setCount(a);
                shangji.setMonkey(b==null?0.0:Double.valueOf(b));

                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(bb==0.0){
                    f=0.0;
                }else{
                    f=shangji.getMonkey()/bb;
                }
                shangji.setHjh(c+"%");
                shangji.setNkk(f+"%");
                list.add(shangji);
            }
            if(i==4){
                Shangji shangji=new Shangji();
                Integer a=businessService.codeJdRen4();
                String b=businessService.codeJdmonkey4();
                shangji.setCount(a);
                shangji.setMonkey(b==null?0.0:Double.valueOf(b));
                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(bb==0.0){
                    f=0.0;
                }else{
                    f=shangji.getMonkey()/bb;
                }
                shangji.setHjh(c+"%");
                shangji.setNkk(f+"%");
                list.add(shangji);
            }
            if(i==5){
                Shangji shangji=new Shangji();
                Integer a=businessService.codeJdRen5();
                String b=businessService.codeJdmonkey5();
                shangji.setCount(a);
                shangji.setMonkey(b==null?0.0:Double.valueOf(b));

                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(bb==0.0){
                    f=0.0;
                }else{
                    f=shangji.getMonkey()/bb;
                }
                shangji.setHjh(c+"%");
                shangji.setNkk(f+"%");
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



    //上季度
    @ResponseBody
    @RequestMapping("/sumbusinessSJd.do")
    public AccountJson sumbusinessSJd(AccountJson accountJson){
        List<Shangji> list=new ArrayList<>();
        Integer num=businessService.codeSJdRen1();
        String d=businessService.codeSJdmonkey1();
        Double bb=0.0;
        if(businessService.codeSJdmonkey1()=="null"||businessService.codeSJdmonkey1()==null||businessService.codeSJdmonkey1()==""){
            bb=0.0;
        }else{
            bb=Double.valueOf(d);
        }
        for (int i=1;i<=5;i++){

            if(i==1){
                Shangji shangji=new Shangji();
                shangji.setCount(num);
                shangji.setMonkey(bb);
                shangji.setHjh("100%");
                shangji.setNkk("100%");
                list.add(shangji);
            }
            if(i==2){
                Shangji shangji=new Shangji();
                Integer a=businessService.codeSJdRen2();

                String b=businessService.codeSJdmonkey2();

                shangji.setCount(a);
                shangji.setMonkey(b==null?0.0:Double.valueOf(b));

                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(bb==0.0){
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
                Integer a=businessService.codeSJdRen3();
                String b=businessService.codeSJdmonkey3();
                shangji.setCount(a);
                shangji.setMonkey(b==null?0.0:Double.valueOf(b));

                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(bb==0.0){
                    f=0.0;
                }else{
                    f=shangji.getMonkey()/bb;
                }
                shangji.setHjh(c+"%");
                shangji.setNkk(f+"%");
                list.add(shangji);
            }
            if(i==4){
                Shangji shangji=new Shangji();
                Integer a=businessService.codeSJdRen4();
                String b=businessService.codeSJdmonkey4();
                shangji.setCount(a);
                shangji.setMonkey(b==null?0.0:Double.valueOf(b));
                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(bb==0.0){
                    f=0.0;
                }else{
                    f=shangji.getMonkey()/bb;
                }
                shangji.setHjh(c+"%");
                shangji.setNkk(f+"%");
                list.add(shangji);
            }
            if(i==5){
                Shangji shangji=new Shangji();
                Integer a=businessService.codeSJdRen5();
                String b=businessService.codeSJdmonkey5();
                shangji.setCount(a);
                shangji.setMonkey(b==null?0.0:Double.valueOf(b));

                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(bb==0.0){
                    f=0.0;
                }else{
                    f=shangji.getMonkey()/bb;
                }
                shangji.setHjh(c+"%");
                shangji.setNkk(f+"%");
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




    //年度
    @ResponseBody
    @RequestMapping("/sumbusinessN.do")
    public AccountJson sumbusinessN(AccountJson accountJson){
        List<Shangji> list=new ArrayList<>();
        Integer num=businessService.codeNRen1();
        String d=businessService.codeNmonkey1();
        Double bb=0.0;
        if(businessService.codeNmonkey1()=="null"||businessService.codeNmonkey1()==null||businessService.codeNmonkey1()==""){
            bb=0.0;
        }else{
            bb=Double.valueOf(d);
        }
        for (int i=1;i<=5;i++){

            if(i==1){
                Shangji shangji=new Shangji();
                shangji.setCount(num);
                shangji.setMonkey(bb);
                shangji.setHjh("100%");
                shangji.setNkk("100%");
                list.add(shangji);
            }
            if(i==2){
                Shangji shangji=new Shangji();
                Integer a=businessService.codeNRen2();

                String b=businessService.codeNmonkey2();

                shangji.setCount(a);
                shangji.setMonkey(b==null?0.0:Double.valueOf(b));

                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(bb==0.0){
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
                Integer a=businessService.codeNRen3();
                String b=businessService.codeNmonkey3();
                shangji.setCount(a);
                shangji.setMonkey(b==null?0.0:Double.valueOf(b));

                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(bb==0.0){
                    f=0.0;
                }else{
                    f=shangji.getMonkey()/bb;
                }
                shangji.setHjh(c+"%");
                shangji.setNkk(f+"%");
                list.add(shangji);
            }
            if(i==4){
                Shangji shangji=new Shangji();
                Integer a=businessService.codeNRen4();
                String b=businessService.codeNmonkey4();
                shangji.setCount(a);
                shangji.setMonkey(b==null?0.0:Double.valueOf(b));
                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(bb==0.0){
                    f=0.0;
                }else{
                    f=shangji.getMonkey()/bb;
                }
                shangji.setHjh(c+"%");
                shangji.setNkk(f+"%");
                list.add(shangji);
            }
            if(i==5){
                Shangji shangji=new Shangji();
                Integer a=businessService.codeNRen5();
                String b=businessService.codeNmonkey5();
                shangji.setCount(a);
                shangji.setMonkey(b==null?0.0:Double.valueOf(b));

                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(bb==0.0){
                    f=0.0;
                }else{
                    f=shangji.getMonkey()/bb;
                }
                shangji.setHjh(c+"%");
                shangji.setNkk(f+"%");
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



    //上年
    @ResponseBody
    @RequestMapping("/sumbusinessSN.do")
    public AccountJson sumbusinessSN(AccountJson accountJson){
        List<Shangji> list=new ArrayList<>();
        Integer num=businessService.codeSNRen1();
        String d=businessService.codeSNmonkey1();
        Double bb=0.0;
        if(businessService.codeSNmonkey1()=="null"||businessService.codeSNmonkey1()==null||businessService.codeSNmonkey1()==""){
          bb=0.0;
        }else{
             bb=Double.valueOf(d);
        }

        for (int i=1;i<=5;i++){

            if(i==1){
                Shangji shangji=new Shangji();
                shangji.setCount(num);
                shangji.setMonkey(bb);
                shangji.setHjh("100%");
                shangji.setNkk("100%");
                list.add(shangji);
            }
            if(i==2){
                Shangji shangji=new Shangji();
                Integer a=businessService.codeSNRen2();

                String b=businessService.codeSNmonkey2();

                shangji.setCount(a);
                shangji.setMonkey(b==null?0.0:Double.valueOf(b));

                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(bb==0.0){
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
                Integer a=businessService.codeSNRen3();
                String b=businessService.codeSNmonkey3();
                shangji.setCount(a);
                shangji.setMonkey(b==null?0.0:Double.valueOf(b));

                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(bb==0.0){
                    f=0.0;
                }else{
                    f=shangji.getMonkey()/bb;
                }
                shangji.setHjh(c+"%");
                shangji.setNkk(f+"%");
                list.add(shangji);
            }
            if(i==4){
                Shangji shangji=new Shangji();
                Integer a=businessService.codeSNRen4();
                String b=businessService.codeSNmonkey4();
                shangji.setCount(a);
                shangji.setMonkey(b==null?0.0:Double.valueOf(b));
                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(bb==0.0){
                    f=0.0;
                }else{
                    f=shangji.getMonkey()/bb;
                }
                shangji.setHjh(c+"%");
                shangji.setNkk(f+"%");
                list.add(shangji);
            }
            if(i==5){
                Shangji shangji=new Shangji();
                Integer a=businessService.codeSNRen5();
                String b=businessService.codeSNmonkey5();
                shangji.setCount(a);
                shangji.setMonkey(b==null?0.0:Double.valueOf(b));

                double c;
                try {
                    c=num/shangji.getCount();
                } catch (ArithmeticException e) {
                    c=0.0;
                }
                double f;
                if(bb==0.0){
                    f=0.0;
                }else{
                    f=shangji.getMonkey()/bb;
                }
                shangji.setHjh(c+"%");
                shangji.setNkk(f+"%");
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


//    根据行业分布查询
    @ResponseBody
    @RequestMapping("/queryByindustry.do")
    public AccountJson queryByindustry(AccountJson accountJson){
        List<Industry_Sources> list=new ArrayList<>();
        for(int i=1;i<=5;i++){
            if(i==1){
                Industry_Sources industrySources=new Industry_Sources();
                industrySources=businessService.queryByindustry("IT|互联网|通信|电子");
                industrySources.setName("IT|互联网|通信|电子");
                list.add(industrySources);
            }

            if(i==2){
                Industry_Sources industrySources=new Industry_Sources();
                industrySources=businessService.queryByindustry("金融|银行|保险");
                industrySources.setName("金融|银行|保险");
                list.add(industrySources);
            }
            if(i==3){
                Industry_Sources industrySources=new Industry_Sources();
                industrySources=businessService.queryByindustry("房产|建筑建设|物业");
                industrySources.setName("房产|建筑建设|物业");
                list.add(industrySources);
            }
            if(i==4){
                Industry_Sources industrySources=new Industry_Sources();
                industrySources=businessService.queryByindustry("广告|传媒|印刷出版");
                industrySources.setName("广告|传媒|印刷出版");
                list.add(industrySources);
            }
            if(i==5){
                Industry_Sources industrySources=new Industry_Sources();
                industrySources=businessService.queryByindustry("医药生物|医疗保健");
                industrySources.setName("医药生物|医疗保健");
                list.add(industrySources);
            }


        }
        accountJson.setCode(0);
        accountJson.setCount(list.size());
        accountJson.setData(list);

        return accountJson;

    }



    //    根据商机来源查询
    @ResponseBody
    @RequestMapping("/querylaiyuanindustry.do")
    public AccountJson querylaiyuanindustry(AccountJson accountJson){
        List<Industry_Sources> list=new ArrayList<>();
        for(int i=1;i<=5;i++){
            if(i==1){
                Industry_Sources industrySources=new Industry_Sources();
                industrySources=businessService.querysjly("老客户");
                industrySources.setName("老客户");
                list.add(industrySources);
            }

            if(i==2){
                Industry_Sources industrySources=new Industry_Sources();
                industrySources=businessService.querysjly("代理商");
                industrySources.setName("代理商");
                list.add(industrySources);
            }
            if(i==3){
                Industry_Sources industrySources=new Industry_Sources();
                industrySources=businessService.querysjly("独立开发");
                industrySources.setName("独立开发");
                list.add(industrySources);
            }
            if(i==4){
                Industry_Sources industrySources=new Industry_Sources();
                industrySources=businessService.querysjly("合作伙伴");
                industrySources.setName("合作伙伴");
                list.add(industrySources);
            }
            if(i==5){
                Industry_Sources industrySources=new Industry_Sources();
                industrySources=businessService.querysjly("电话访问");
                industrySources.setName("电话访问");
                list.add(industrySources);
            }


        }
        accountJson.setCode(0);
        accountJson.setCount(list.size());
        accountJson.setData(list);

        return accountJson;

    }

}
