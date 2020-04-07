package com.hy.crm.controller;

import com.hy.crm.entity.Clients;
import com.hy.crm.service.impl.BusinessServiceImpl;
import com.hy.crm.service.impl.ClientsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/crm/business")
public class BusinessController {

    @Autowired
    BusinessServiceImpl businessService;

    @Autowired
    ClientsServiceImpl clientsService;


    @RequestMapping("/clients_queryall.do")
    @ResponseBody
    public List<Clients> clients_queryall(){
        List<Clients> clients=clientsService.asc_c_name();
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
}
