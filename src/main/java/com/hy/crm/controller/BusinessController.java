package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Clients;
import com.hy.crm.service.impl.BusinessServiceImpl;
import com.hy.crm.service.impl.ClientsServiceImpl;
import com.hy.crm.util.AccountJson;
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
