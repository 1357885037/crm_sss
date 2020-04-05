package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Serves;
import com.hy.crm.service.IServesService;
import com.hy.crm.util.AccountJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/crm/serves")
public class ServesController {
    @Autowired
    private IServesService servesService;

    @ResponseBody
    @RequestMapping("/queryAllServe.do")
    public AccountJson queryAllServe(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit" ,defaultValue = "3")Integer limit){
//        Page page1 =PageHelper.startPage(page-1,page*limit,true);
        QueryWrapper<Serves> queryWrapper=new QueryWrapper<>();
        List<Serves> servesList = servesService.list(queryWrapper);
        AccountJson accountJson=new AccountJson();
        accountJson.setCode(0);
        accountJson.setCount(servesList.size());
        accountJson.setData(servesList);
        return accountJson;
    }

    @RequestMapping("/addsever.do")
    public String addsever(Serves serves){


    return "";
    }

}
