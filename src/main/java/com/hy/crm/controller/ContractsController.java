package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Contracts;
import com.hy.crm.service.IContractsService;
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
@RequestMapping("/crm/contracts")
public class ContractsController {

    @Autowired
    private IContractsService contractsService;

    @ResponseBody
    @RequestMapping("/queryCon.do")
    public AccountJson queryCon(AccountJson accountJson){
        QueryWrapper<Contracts> queryWrapper=new QueryWrapper<>();
        List<Contracts> contractsList=contractsService.list(queryWrapper);
        accountJson.setCode(1);
        accountJson.setCount(contractsList.size());
        accountJson.setData(contractsList);
        accountJson.setMsg("");
        return accountJson;
    }

    @RequestMapping("/sumContracts.do")
    public Integer sumContracts(){
        Integer i=0;
        QueryWrapper<Contracts> queryWrapper=new QueryWrapper<>();
        try {
            i=contractsService.count(queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }


    //    查询本周新增合同金额
    @RequestMapping("/sumMeonkey.do")
    Double sumMeonkey(){
        Double d;
        try {
            d=contractsService.sumMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    //    查询上周新增合同金额
    @RequestMapping("/sumSMeonkey.do")
    Double sumSMeonkey(){
        Double d;
        try {
            d=contractsService.sumSMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }


    //查询本月新增合同金额
    @RequestMapping("/sumYMeonkey.do")
    Double sumYMeonkey(){
        Double d;
        try {
            d=contractsService.sumYMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    //查询上月新增合同金额
    @RequestMapping("/sumSYMeonkey.do")
    Double sumSYMeonkey(){
        Double d;
        try {
            d=contractsService.sumSYMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    //查询本季度新增合同金额
    @RequestMapping("/sumJdMeonkey.do")
    Double sumJdMeonkey(){
        Double d;
        try {
            d=contractsService.sumJdMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    //查询上季度新增合同金额
    @RequestMapping("/sumSJdMeonkey.do")
    Double sumSJdMeonkey(){
        Double d;
        try {
            d=contractsService.sumSJdMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    //查询本年新增金额合同
    @RequestMapping("/sumNMeonkey.do")
    Double sumNMeonkey(){
        Double d;
        try {
            d=contractsService.sumNMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    //查询上年新增合同金额
    @RequestMapping("/sumSNMeonkey.do")
    Double sumSNMeonkey(){
        Double d;
        try {
            d=contractsService.sumSNMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

//   已完成的合同////////////////////////
    @RequestMapping("/fulfillsumMeonkey.do")
     Double fulfillsumMeonkey() {
        Double d;
        try {
            d=contractsService.fulfillsumMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    @RequestMapping("/fulfillsumSMeonkey.do")
     Double fulfillsumSMeonkey() {
        Double d;
        try {
            d=contractsService.fulfillsumSMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    @RequestMapping("/fulfillsumYMeonkey.do")
     Double fulfillsumYMeonkey() {
        Double d;
        try {
            d=contractsService.fulfillsumYMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    @RequestMapping("/fulfillsumSYMeonkey.do")
     Double fulfillsumSYMeonkey() {
        Double d;
        try {
            d=contractsService.fulfillsumSYMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    @RequestMapping("/fulfillsumJdMeonkey.do")
     Double fulfillsumJdMeonkey() {
        Double d;
        try {
            d=contractsService.fulfillsumJdMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    @RequestMapping("/fulfillsumSJdMeonkey.do")
     Double fulfillsumSJdMeonkey() {
        Double d;
        try {
            d=contractsService.fulfillsumSJdMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    @RequestMapping("/fulfillsumNMeonkey.do")
     Double fulfillsumNMeonkey() {
        Double d;
        try {
            d=contractsService.fulfillsumNMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    @RequestMapping("/fulfillsumSNMeonkey.do")
     Double fulfillsumSNMeonkey() {
        Double d;
        try {
            d=contractsService.fulfillsumSNMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }



}
