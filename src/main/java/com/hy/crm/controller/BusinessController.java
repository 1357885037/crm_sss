package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Clients;
import com.hy.crm.entity.Users;
import com.hy.crm.service.impl.BusinessServiceImpl;
import com.hy.crm.service.impl.ClientsServiceImpl;
import com.hy.crm.service.impl.UsersServiceImpl;
import com.hy.crm.util.AccountJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
@Controller
@RequestMapping("/crm/business")
public class BusinessController {

    @Autowired
    BusinessServiceImpl businessService;

    @Autowired
    ClientsServiceImpl clientsService;

    @Autowired
    UsersServiceImpl usersService;

    @ResponseBody
    @RequestMapping("/queryBusiness.do")
    public AccountJson queryBusiness(AccountJson accountJson){
        QueryWrapper<Business> queryWrapper=new QueryWrapper<>();
        List<Business> businessList=businessService.list(queryWrapper);
        accountJson.setCode(0);
        accountJson.setCount(businessList.size());
        accountJson.setData(businessList);

        return accountJson;
    }

    @RequestMapping("/myBusiness.do")
    public String myBusiness(HttpSession session, Model model){
        Users user= (Users) session.getAttribute("users");
        model.addAttribute("user",user);
        return "business_management/business_management";
    }



    @RequestMapping("/clients_queryall.do")
    @ResponseBody
    public List<Clients> clients_queryall(HttpSession session){
        List<Clients> clients=clientsService.asc_c_name();

        System.out.println("session测试"+session.getAttribute("u_name"));
        return clients;
    }

    @RequestMapping("/clients_getById.do")
    @ResponseBody
    public Clients clients_getById(String c_id){
        System.out.println("测试c_id有没有值"+c_id);
        Clients clients= clientsService.getById(c_id);
        System.out.println("根据客户追加："+clients.toString());
    return clients;
    }

    @RequestMapping("/in_charge_of.do")
    @ResponseBody
    public List<Users> query_User(){
        return usersService.asc_u_Realname();
    }


    @RequestMapping("/add_Business")
    @ResponseBody
    public String add_Business(Business business){
        System.out.println("添加商机测试。。。。。。。。。。。。。。。。");
        System.out.println(business.toString());
        //我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取String类型的时间
        String createdate = sdf.format(date);
        business.setB_current_time(createdate);
        businessService.save(business);

        return "1";
    }
    @ResponseBody
    @RequestMapping("/update_Business.do")
    public String update_Business(Business business){
        System.out.println("修改商机测试。。。。。。。。。。。。。。。。");
        System.out.println("看看"+business.toString());
        businessService.updateById(business);
        return "1";
    }

    @ResponseBody
    @RequestMapping("/acs_b_name.do")
    public List<Business> acs_b_name(){
        return  businessService.asc_b_name();
    }

    @ResponseBody
    @RequestMapping("/sumMeonkey.do")
    public Double sumMonkey(){
        Double d;
        try {
            d=businessService.sumMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }
    @ResponseBody
    @RequestMapping("/sumSMeonkey.do")
    public Double sumSMonkey(){
        Double d;
        try {
            d=businessService.sumSMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }


    @RequestMapping("/sumBusiness.do")
    @ResponseBody
    public Integer sumBusiness(){
        Integer i=0;
        try {
            QueryWrapper<Business> queryWrapper=new QueryWrapper<>();
            i=businessService.count(queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }



    //查询本月新增商机金额
    @ResponseBody
@RequestMapping("/sumYMeonkey.do")
    public Double sumYMeonkey(){
        Double d;
        try {
            d=businessService.sumYMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    //查询上月新增商机金额
    @ResponseBody
    @RequestMapping("/sumSYMeonkey.do")
    Double sumSYMeonkey(){
        Double d;
        try {
            d=businessService.sumSYMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    //查询本季度新增商机金额
    @ResponseBody
    @RequestMapping("/sumJdMeonkey.do")
    Double sumJdMeonkey(){
        Double d;
        try {
            d=businessService.sumJdMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    //查询上季度新增商机金额
    @ResponseBody
    @RequestMapping("/sumSJdMeonkey.do")
    Double sumSJdMeonkey(){
        Double d;
        try {
            d=businessService.sumSJdMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    //查询本年新增商机金额
    @ResponseBody
    @RequestMapping("/sumNMeonkey.do")
    Double sumNMeonkey(){
        Double d;
        try {
            d=businessService.sumNMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    //查询上年新增商机金额
    @ResponseBody
    @RequestMapping("/sumSNMeonkey.do")
    Double sumSNMeonkey(){
        Double d;
        try {
            d=businessService.sumSNMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;

    }



}
