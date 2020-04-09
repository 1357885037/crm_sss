package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Client_finance;
import com.hy.crm.entity.Clients;
import com.hy.crm.service.impl.Client_financeServiceImpl;
import com.hy.crm.service.impl.ClientsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/crm/clients")
public class ClientsController {

    @Autowired
    ClientsServiceImpl clientsService;

    @Autowired
    Client_financeServiceImpl client_financeService;

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

    @RequestMapping("/Sumclients.do")
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
