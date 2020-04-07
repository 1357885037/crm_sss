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

}
