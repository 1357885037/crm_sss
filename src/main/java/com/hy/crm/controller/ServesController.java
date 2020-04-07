package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.entity.Serves;
import com.hy.crm.service.IServesService;
import com.hy.crm.util.AccountJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/crm/serves")
public class ServesController {
    @Autowired
    private IServesService servesService;

    @ResponseBody
    @RequestMapping("/queryAllServe.do")
    public AccountJson queryAllServe(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit){

       IPage<Serves> servesIPage = servesService.pages(page,limit);
        AccountJson accountJson=new AccountJson();
        accountJson.setCode(0);
        accountJson.setMsg("");
        accountJson.setCount(Integer.parseInt(String.valueOf(servesIPage.getTotal())));
        accountJson.setData(servesIPage.getRecords());
        return accountJson;
    }

    @RequestMapping("/addsever.do")
    public String addsever(Serves serves){
        servesService.save(serves);

    return "/page/serve/serves.html";
    }

}
