package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crm.entity.*;
import com.hy.crm.service.impl.BusinessServiceImpl;
import com.hy.crm.service.impl.Client_financeServiceImpl;
import com.hy.crm.service.impl.ClientsServiceImpl;
import com.hy.crm.util.AccountJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/crm/clients")
public class ClientsController {

    @Autowired
    ClientsServiceImpl clientsService;

    @Autowired
    Client_financeServiceImpl client_financeService;

    @Autowired
    BusinessServiceImpl businessService;



    @RequestMapping("/queryall.do")
    @ResponseBody
    public AccountJson queryall(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit,String tiaojian,Clients clients){

        if(tiaojian!=null){
            clients.setStatu(Integer.parseInt(tiaojian));
        }

        Page pageHelper= PageHelper.startPage(page,limit,true);
        List<Customer_management> list=clientsService.customer_managements(clients);

        AccountJson accountJson=new AccountJson();
        accountJson.setCode(0);
        accountJson.setMsg("");
        accountJson.setCount((int) pageHelper.getTotal());
        accountJson.setData(list);

        return accountJson;
    }

    @RequestMapping("/addClients.do")
    @ResponseBody
    public String addClients(Clients clients, Client_finance client_finance){
        System.out.println("客户信息"+clients.toString());
        System.out.println("财务信息"+client_finance);
        System.out.println(clients.getC_id());
        QueryWrapper<Clients> queryWrapper=new QueryWrapper();
        queryWrapper.eq("c_name",clients.getC_name());
        Clients clients1=clientsService.getOne(queryWrapper);
        if (clients1==null){
            clientsService.save(clients);

            //add进去重新查询获取uuid 赋值给客户财务信息表
            QueryWrapper<Clients> queryWrapper2=new QueryWrapper();
            queryWrapper.eq("c_name",clients.getC_name());
            Clients clients2=clientsService.getOne(queryWrapper);

            client_finance.setC_id(clients.getC_id());
            //add财务信息表
            client_financeService.save(client_finance);
            return "1";
        }else{
            return "2";
        }
    }

    @RequestMapping("/redact.do")
    public String redact(String c_id, Model model){
        System.out.println("=========="+c_id);
        Clients clients=clientsService.getById(c_id);
        Client_finance client_finance=client_financeService.getbyc_id(c_id);

        model.addAttribute("clients",clients);
        model.addAttribute("client_finance",client_finance);
        return "customer_management/redact_clients";
    }

    @RequestMapping("/update_Clients.do")
    @ResponseBody
    public String update_Clients(Clients clients,Client_finance client_finance){
        System.out.println("异步提交中");
        System.out.println(clients.toString());
        System.out.println(client_finance.toString());
        clientsService.updateById(clients);
        client_financeService.updateByC_id(client_finance);

        return "1";
    }

    //删除暂时关闭
    @RequestMapping("/delete_Clients.do")
    @ResponseBody
    public String deleteByid(String c_id){
        System.out.println("====：==="+c_id);
      /*  client_financeService.removeById(c_id);
        clientsService.removeById(c_id);*/
        return "1";
    }

    @RequestMapping("/customer_contract.do")
    public String customer_contract(String c_id,Model model){
        model.addAttribute("c_id",c_id);
        System.out.println("进来 走过。。");
        return "customer_management/customer_contract";
    }

    @RequestMapping("/customer_contract2.do")
    @ResponseBody
    public AccountJson customer_contract2(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit,Model model, Business business){
       Page pageHelper= PageHelper.startPage(page,limit,true);
       List<Customer_contract> list=clientsService.customer_contract(business);
       System.out.println("测。。。。。。"+list.size());
        AccountJson accountJson=new AccountJson();
        accountJson.setCode(0);
        accountJson.setMsg("");
        accountJson.setCount((int) pageHelper.getTotal());
        accountJson.setData(list);
        return accountJson;
    }

    @RequestMapping("/getByid_business.do")
    public String getByid_business(String b_id,Model model){
        Business business=businessService.getById(b_id);
        model.addAttribute("business",business);
        return "customer_management/redact_business";
    }


    @RequestMapping("/Sumclients.do")
    @ResponseBody
    public Integer Sumclients(){
        Integer i=0;
        try {
            QueryWrapper<Clients> queryWrapper=new QueryWrapper<>();
            i=clientsService.count(queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

}
