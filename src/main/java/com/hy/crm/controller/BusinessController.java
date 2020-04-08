package com.hy.crm.controller;

import com.hy.crm.entity.Business;
import com.hy.crm.entity.Clients;
import com.hy.crm.entity.Users;
import com.hy.crm.service.impl.BusinessServiceImpl;
import com.hy.crm.service.impl.ClientsServiceImpl;
import com.hy.crm.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping("/crm/business")
public class BusinessController {

    @Autowired
    BusinessServiceImpl businessService;

    @Autowired
    ClientsServiceImpl clientsService;

    @Autowired
    UsersServiceImpl usersService;

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
}
