package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crm.entity.*;
import com.hy.crm.service.impl.BusinessServiceImpl;
import com.hy.crm.service.impl.ClientsServiceImpl;
import com.hy.crm.service.impl.UsersServiceImpl;
import com.hy.crm.util.AccountJson;
import com.hy.crm.util.HolidayRequest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequiresPermissions("Mybusiness:select")
    @RequestMapping("/myBusiness.do")
    public String myBusiness(HttpSession session, Model model){
        Users user= (Users) session.getAttribute("users");
        model.addAttribute("user",user);
        return "business_management/business_management2";
    }



    @RequestMapping("/clients_queryall.do")
    @ResponseBody
    public List<Clients> clients_queryall(HttpSession session){
        List<Clients> clients=clientsService.asc_c_name();
        return clients;
    }

    @RequestMapping("/clients_getById.do")
    @ResponseBody
    public Clients clients_getById(String c_id){
        Clients clients= clientsService.getById(c_id);
        return clients;
    }

    @RequestMapping("/in_charge_of.do")
    @ResponseBody
    public List<Users> query_User(){
        return usersService.asc_u_Realname();
    }


    @RequestMapping("/add_Business")
    @ResponseBody
    public String add_Business(Business business,String u_idsp,HttpSession session){

        QueryWrapper<Business> queryWrapper=new QueryWrapper();
        queryWrapper.eq("b_name",business.getB_name());
        Business ces=(Business)businessService.getObj(queryWrapper);
        if(ces!=null){
            return "2";
        }else{

        System.out.println(business.toString());
        //我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取String类型的时间
        String createdate = sdf.format(date);
        business.setB_current_time(createdate);
        businessService.save(business);

            QueryWrapper<Business> queryWrapper2=new QueryWrapper();
            queryWrapper2.eq("b_name",business.getB_name());
            Business ces2=(Business)businessService.getObj(queryWrapper);

        //获取申请人
        Users user=(Users)session.getAttribute("users");
        FlowableBena2 flowableBena2=new FlowableBena2(user.getU_Id(),business.getB_name(),"0",ces2.getB_id(),u_idsp,-1);
        HolidayRequest.start(flowableBena2);


        return "1";
        }
    }
    @ResponseBody
    @RequestMapping("/update_Business.do")
    public String update_Business(Business business){
        try {
            businessService.updateById(business);
            return "1";
        }catch (Exception e){
            return "2";
        }
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
    public Double sumSYMeonkey(){
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
    public Double sumJdMeonkey(){
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
    public Double sumSJdMeonkey(){
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
    public Double sumNMeonkey(){
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
    public Double sumSNMeonkey(){
        Double d;
        try {
            d=businessService.sumSNMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;

    }

    @RequestMapping("/Concern.do")
    @ResponseBody
    public String Concern(String str,HttpSession session){
        Users  users= (Users) session.getAttribute("users");
        String[] sss=str.split(",");
        int c=0;
        for (int i = sss.length - 1; i >= 0; i--) {
           Business business=businessService.getById(sss[i]);
           if(business.getUse_attention().indexOf(users.getU_Id())==-1){
               String use=business.getUse_attention()+","+users.getU_Id();
               business.setUse_attention(use);
               businessService.updateById(business);
               c++;
           }
        }

        if(c>0){
            return "1";
        }else {
            return "0";
        }

    }

    @RequestMapping("/no_Concern.do")
    @ResponseBody
    public String no_Concern(String str,HttpSession session){
        Users  users= (Users) session.getAttribute("users");
        String[] sss=str.split(",");
        int c=0;
        for (int i = sss.length - 1; i >= 0; i--) {
            Business business=businessService.getById(sss[i]);
            if(business.getUse_attention().indexOf(users.getU_Id())!=-1){
                String [] use=business.getUse_attention().split(",");
                String strr="";
                for (int i1 = 0; i1 < use.length; i1++) {
                  if(!use[i1].equals(users.getU_Id())){
                      strr+=use[i1]+",";
                  }
                }
                if (strr.length() > 0) {
                   strr=strr.substring(0, strr.length()-1);
                }

                business.setUse_attention(strr);
                businessService.updateById(business);
                c++;
            }
        }

        if(c>0){
            return "1";
        }else {
            return "0";
        }
    }



    @ResponseBody
    @RequestMapping("/sp_business.do")
    public AccountJson sp_business(HttpSession session, @RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit){

        Users user=(Users)session.getAttribute("users");

        Page pageHelper= PageHelper.startPage(page,limit,true);
        List<FlowableBena2> list=HolidayRequest.select(user.getU_Id());
        AccountJson accountJson=new AccountJson();
        accountJson.setCode(0);
        accountJson.setMsg("");
        accountJson.setCount((int) pageHelper.getTotal());
        accountJson.setData(list);
        return accountJson;
    }

    @RequestMapping("/sp.do")
    @ResponseBody
    public String sp(String str,HttpSession session){
        System.out.println("task_id"+str);
        Users users=(Users)session.getAttribute("users");
        HolidayRequest.sp(users.getU_Id(),Integer.parseInt(str));
        return "1";
    }

    @RequestMapping("/no_sp")
    @ResponseBody
    public String no_sp(String str,HttpSession session){
        System.out.println("task_id"+str);
        Users users=(Users)session.getAttribute("users");
        HolidayRequest.no_sp(users.getU_Id(),Integer.parseInt(str));
        return "1";
    }

}
