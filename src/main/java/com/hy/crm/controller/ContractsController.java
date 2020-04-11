package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crm.entity.Contracts;
import com.hy.crm.service.IContractsService;
import com.hy.crm.service.impl.ContractsServiceImpl;
import com.hy.crm.util.AccountJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/crm/contracts")
public class ContractsController {

    @Autowired
    private IContractsService contractsService;

    @Autowired
    private ContractsServiceImpl contractsServiceImpl;

    @RequestMapping("/queryall.do")
    @ResponseBody
    public AccountJson queryall(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit,Contracts contracts){
        Page pageHelper= PageHelper.startPage(page,limit,true);
        List<Contracts> list=contractsServiceImpl.queryall(contracts);
        AccountJson accountJson=new AccountJson();
        accountJson.setCode(0);
        accountJson.setMsg("");
        accountJson.setCount((int) pageHelper.getTotal());
        accountJson.setData(list);
        return accountJson;
    }


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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
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
