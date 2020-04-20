package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crm.entity.*;
import com.hy.crm.service.*;
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
    @Autowired
    private IClientsService iClientsService;

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
                industrySources=businessService.queryByindustry("老客户");
                industrySources.setName("老客户");
                list.add(industrySources);
            }

            if(i==2){
                Industry_Sources industrySources=new Industry_Sources();
                industrySources=businessService.queryByindustry("代理商");
                industrySources.setName("代理商");
                list.add(industrySources);
            }
            if(i==3){
                Industry_Sources industrySources=new Industry_Sources();
                industrySources=businessService.queryByindustry("独立开发");
                industrySources.setName("独立开发");
                list.add(industrySources);
            }
            if(i==4){
                Industry_Sources industrySources=new Industry_Sources();
                industrySources=businessService.queryByindustry("合作伙伴");
                industrySources.setName("合作伙伴");
                list.add(industrySources);
            }
            if(i==5){
                Industry_Sources industrySources=new Industry_Sources();
                industrySources=businessService.queryByindustry("电话访问");
                industrySources.setName("电话访问");
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
                industrySources=businessService.querysjly("IT|互联网|通信|电子");
                industrySources.setName("IT|互联网|通信|电子");
                list.add(industrySources);
            }

            if(i==2){
                Industry_Sources industrySources=new Industry_Sources();
                industrySources=businessService.querysjly("金融|银行|保险");
                industrySources.setName("金融|银行|保险");
                list.add(industrySources);
            }
            if(i==3){
                Industry_Sources industrySources=new Industry_Sources();
                industrySources=businessService.querysjly("房产|建筑建设|物业");
                industrySources.setName("房产|建筑建设|物业");
                list.add(industrySources);
            }
            if(i==4){
                Industry_Sources industrySources=new Industry_Sources();
                industrySources=businessService.querysjly("广告|传媒|印刷出版");
                industrySources.setName("广告|传媒|印刷出版");
                list.add(industrySources);
            }
            if(i==5){
                Industry_Sources industrySources=new Industry_Sources();
                industrySources=businessService.querysjly("医药生物|医疗保健");
                industrySources.setName("医药生物|医疗保健");
                list.add(industrySources);
            }


        }
        accountJson.setCode(0);
        accountJson.setCount(list.size());
        accountJson.setData(list);

        return accountJson;

    }

//    商机数柱状图
      @ResponseBody
    @RequestMapping("/zshangjishu.do")
    public Integer[] zshangjishu(){

        Integer[] arr=new Integer[5];

        QueryWrapper<Business> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("b_source","IT|互联网|通信|电子");
        List<Business> businessList=businessService.list(queryWrapper);
        arr[0]=businessList.size();

        QueryWrapper<Business> queryWrapper2=new QueryWrapper<>();
        queryWrapper2.eq("b_source","金融|银行|保险");
        List<Business> businessList2=businessService.list(queryWrapper2);
        arr[1]=businessList2.size();

        QueryWrapper<Business> queryWrapper3=new QueryWrapper<>();
        queryWrapper3.eq("b_source","房产|建筑建设|物业");
        List<Business> businessList3=businessService.list(queryWrapper3);
        arr[2]=businessList3.size();

        QueryWrapper<Business> queryWrapper4=new QueryWrapper<>();
        queryWrapper4.eq("b_source","广告|传媒|印刷出版");
        List<Business> businessList4=businessService.list(queryWrapper4);
        arr[3]=businessList4.size();

        QueryWrapper<Business> queryWrapper5=new QueryWrapper<>();
        queryWrapper5.eq("b_source","医药生物|医疗保健");
        List<Business> businessList5=businessService.list(queryWrapper5);
        arr[4]=businessList5.size();

        return arr;
    }
//    kehulaiyuan商机数柱状图
      @ResponseBody
    @RequestMapping("/kehuzshangjishu.do")
    public Integer[] kehuzshangjishu(){

        Integer[] arr=new Integer[5];

        QueryWrapper<Clients> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("c_industry","老客户");
        List<Clients> clientsList=iClientsService.list(queryWrapper);
        Integer num=0;
        for(Clients clients:clientsList){
            QueryWrapper<Business> queryWrapper1=new QueryWrapper<>();
            queryWrapper1.eq("c_id",clients.getC_id());
            List<Business> businessList1=businessService.list(queryWrapper1);
            num+=businessList1.size();
        }
        arr[0]=num;

          QueryWrapper<Clients> queryWrapper2=new QueryWrapper<>();
          queryWrapper2.eq("c_industry","代理商");
          List<Clients> clientsList2=iClientsService.list(queryWrapper2);
          Integer num2=0;
          for(Clients clients:clientsList2){
              QueryWrapper<Business> queryWrapper1=new QueryWrapper<>();
              queryWrapper1.eq("c_id",clients.getC_id());
              List<Business> businessList1=businessService.list(queryWrapper1);
              num2+=businessList1.size();
          }
          arr[1]=num2;

          QueryWrapper<Clients> queryWrapper3=new QueryWrapper<>();
          queryWrapper3.eq("c_industry","独立开发");
          List<Clients> clientsList3=iClientsService.list(queryWrapper3);
          Integer num3=0;
          for(Clients clients:clientsList3){
              QueryWrapper<Business> queryWrapper1=new QueryWrapper<>();
              queryWrapper1.eq("c_id",clients.getC_id());
              List<Business> businessList1=businessService.list(queryWrapper1);
              num3+=businessList1.size();
          }
          arr[2]=num3;

          QueryWrapper<Clients> queryWrapper4=new QueryWrapper<>();
          queryWrapper4.eq("c_industry","合作伙伴");
          List<Clients> clientsList4=iClientsService.list(queryWrapper4);
          Integer num4=0;
          for(Clients clients:clientsList4){
              QueryWrapper<Business> queryWrapper1=new QueryWrapper<>();
              queryWrapper1.eq("c_id",clients.getC_id());
              List<Business> businessList1=businessService.list(queryWrapper1);
              num4+=businessList1.size();
          }
          arr[3]=num4;

          QueryWrapper<Clients> queryWrapper5=new QueryWrapper<>();
          queryWrapper5.eq("c_industry","电话访问");
          List<Clients> clientsList5=iClientsService.list(queryWrapper5);
          Integer num5=0;
          for(Clients clients:clientsList5){
              QueryWrapper<Business> queryWrapper1=new QueryWrapper<>();
              queryWrapper1.eq("c_id",clients.getC_id());
              List<Business> businessList1=businessService.list(queryWrapper1);
              num5+=businessList1.size();
          }
          arr[4]=num5;

        return arr;
    }
//    kehulaiyuanqianshu商机数柱状图
      @ResponseBody
    @RequestMapping("/kehuzmonkey.do")
    public double[] kehuzmonkey(){

        double[] arr=new double[5];

        QueryWrapper<Clients> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("c_industry","老客户");
        List<Clients> clientsList=iClientsService.list(queryWrapper);
          double num=0;
        for(Clients clients:clientsList){
            QueryWrapper<Business> queryWrapper1=new QueryWrapper<>();
            queryWrapper1.eq("c_id",clients.getC_id());
            List<Business> businessList1=businessService.list(queryWrapper1);
            for(Business business:businessList1){
                num+=business.getB_monkey().doubleValue();
            }
        }
        arr[0]=num;

          QueryWrapper<Clients> queryWrapper2=new QueryWrapper<>();
          queryWrapper2.eq("c_industry","代理商");
          List<Clients> clientsList2=iClientsService.list(queryWrapper2);
          double num2=0;
          for(Clients clients:clientsList2){
              QueryWrapper<Business> queryWrapper1=new QueryWrapper<>();
              queryWrapper1.eq("c_id",clients.getC_id());
              List<Business> businessList1=businessService.list(queryWrapper1);
              for(Business business:businessList1){
                  num+=business.getB_monkey().doubleValue();
              }
          }
          arr[1]=num2;

          QueryWrapper<Clients> queryWrapper3=new QueryWrapper<>();
          queryWrapper3.eq("c_industry","独立开发");
          List<Clients> clientsList3=iClientsService.list(queryWrapper3);
          double num3=0;
          for(Clients clients:clientsList3){
              QueryWrapper<Business> queryWrapper1=new QueryWrapper<>();
              queryWrapper1.eq("c_id",clients.getC_id());
              List<Business> businessList1=businessService.list(queryWrapper1);
              for(Business business:businessList1){
                  num+=business.getB_monkey().doubleValue();
              }          }
          arr[2]=num3;

          QueryWrapper<Clients> queryWrapper4=new QueryWrapper<>();
          queryWrapper4.eq("c_industry","合作伙伴");
          List<Clients> clientsList4=iClientsService.list(queryWrapper4);
          double num4=0;
          for(Clients clients:clientsList4){
              QueryWrapper<Business> queryWrapper1=new QueryWrapper<>();
              queryWrapper1.eq("c_id",clients.getC_id());
              List<Business> businessList1=businessService.list(queryWrapper1);
              for(Business business:businessList1){
                  num+=business.getB_monkey().doubleValue();
              }
          }
          arr[3]=num4;

          QueryWrapper<Clients> queryWrapper5=new QueryWrapper<>();
          queryWrapper5.eq("c_industry","电话访问");
          List<Clients> clientsList5=iClientsService.list(queryWrapper5);
          double num5=0;
          for(Clients clients:clientsList5){
              QueryWrapper<Business> queryWrapper1=new QueryWrapper<>();
              queryWrapper1.eq("c_id",clients.getC_id());
              List<Business> businessList1=businessService.list(queryWrapper1);
              for(Business business:businessList1){
                  num+=business.getB_monkey().doubleValue();
              }          }
          arr[4]=num5;

        return arr;
    }

    @ResponseBody
    @RequestMapping("/bshangjishu.do")
    public List<Eachtes> bshangjishu(){
        List<Eachtes> businessList=businessService.bshangjishu();
        return businessList;
    }

    @ResponseBody
    @RequestMapping("/bshangjimonkey.do")
    public List<Eachtes> bshangjimonkey( ){
        List<Eachtes> businessList=businessService.zquerybusiness();
        return businessList;
    }

    @ResponseBody
    @RequestMapping("/zshangjimonkey.do")
    public double[] zshangjimonkey(Eachtes eachtes){

        double[] arr=new double[5];

        QueryWrapper<Business> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("b_source","IT|互联网|通信|电子");
        List<Business> businessList=businessService.list(queryWrapper);
        double d=0;
        for(Business business:businessList){
            d+=business.getB_monkey().doubleValue();
        }

        arr[0]=d;

        QueryWrapper<Business> queryWrapper2=new QueryWrapper<>();
        queryWrapper2.eq("b_source","金融|银行|保险");
        List<Business> businessList2=businessService.list(queryWrapper2);
        double d2=0;
        for(Business business:businessList2){
            d2+=business.getB_monkey().doubleValue();
        }
        arr[1]=d2;

        QueryWrapper<Business> queryWrapper3=new QueryWrapper<>();
        queryWrapper3.eq("b_source","房产|建筑建设|物业");
        List<Business> businessList3=businessService.list(queryWrapper3);
        double d3=0;
        for(Business business:businessList3){
            d3+=business.getB_monkey().doubleValue();
        }
        arr[2]=d3;

        QueryWrapper<Business> queryWrapper4=new QueryWrapper<>();
        queryWrapper4.eq("b_source","广告|传媒|印刷出版");
        List<Business> businessList4=businessService.list(queryWrapper4);
        double d4=0;
        for(Business business:businessList4){
            d4+=business.getB_monkey().doubleValue();
        }
        arr[3]=d4;

        QueryWrapper<Business> queryWrapper5=new QueryWrapper<>();
        queryWrapper5.eq("b_source","医药生物|医疗保健");
        List<Business> businessList5=businessService.list(queryWrapper5);
        double d5=0;
        for(Business business:businessList5){
            d5+=business.getB_monkey().doubleValue();
        }
        arr[4]=d5;


        return arr;
    }

    @ResponseBody
    @RequestMapping("/bkehushangjishu.do")
    public List<Eachtes> bkehushangjishu(){

return businessService.bkehushangjigeshu();

    }

    @ResponseBody
    @RequestMapping("/bkehumonkey.do")
    public List<Eachtes> bkehumonkey(){

return businessService.bkehumonkey();

    }


    @ResponseBody
    @RequestMapping("/hetongzhexina.do")
    public Eachtes hetongzhexina(Eachtes e ){

        double[] arrthree=new double[7];
        arrthree[0]=contractsService.querybzy();
        arrthree[1]=contractsService.querybze();
        arrthree[2]=contractsService.querybzs();
        arrthree[3]=contractsService.querybzf();
        arrthree[4]=contractsService.querybzw();
        arrthree[5]=contractsService.querybzl();
        arrthree[6]=contractsService.querybzr();

        double[] arrtwo=new double[7];
        arrtwo[0]=contractsService.queryszy();
        arrtwo[1]=contractsService.querysze();
        arrtwo[2]=contractsService.queryszs();
        arrtwo[3]=contractsService.queryszf();
        arrtwo[4]=contractsService.queryszw();
        arrtwo[5]=contractsService.queryszl();
        arrtwo[6]=contractsService.queryszr();



        Eachtes eachtes=new Eachtes();
        eachtes.setArrthree(arrthree);
        eachtes.setArrtwo(arrtwo);

return eachtes;

    }

}
