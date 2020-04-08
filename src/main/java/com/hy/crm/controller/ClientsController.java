package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Client_finance;
import com.hy.crm.entity.Clients;
import com.hy.crm.entity.Customer_management;
import com.hy.crm.service.impl.Client_financeServiceImpl;
import com.hy.crm.service.impl.ClientsServiceImpl;
import com.hy.crm.util.AccountJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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



    @RequestMapping("/queryall.do")
    @ResponseBody
    public AccountJson queryall(){

        List<Customer_management> list=clientsService.customer_managements();

        AccountJson accountJson=new AccountJson();
        accountJson.setCode(0);
        accountJson.setMsg("");
        accountJson.setCount(list.size());
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
}
