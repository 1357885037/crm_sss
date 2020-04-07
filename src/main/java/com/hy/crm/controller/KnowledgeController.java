package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Knowledge;
import com.hy.crm.service.IKnowledgeService;
import com.hy.crm.util.AccountJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mq
 * @since 2020-04-05
 */
@RestController
@RequestMapping("/crm/knowledge")
public class KnowledgeController {

    @Autowired
    private IKnowledgeService knowledgeService;

    @ResponseBody
    @RequestMapping("/queryKonw.do")
    public AccountJson queryKonw(AccountJson accountJson){
        QueryWrapper<Knowledge> queryWrapper=new QueryWrapper<>();
        List<Knowledge> knowledgeList=knowledgeService.list(queryWrapper);
        accountJson.setData(knowledgeList);
        accountJson.setCount(knowledgeList.size());
        accountJson.setCode(0);
        accountJson.setMsg("11");
        return accountJson;
    }

    @ResponseBody
    @RequestMapping("/queryKonwid.do")
    public ModelAndView queryKonwid(String kid, ModelAndView ModelAndView){

        QueryWrapper<Knowledge> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("k_id",kid);
        Knowledge  knowledge=knowledgeService.getOne(queryWrapper);
        System.out.println(knowledge.toString()+"1564545643213544321545");
        ModelAndView.addObject("konw",knowledge);
        ModelAndView.setViewName("/page/desktop/konw.html");
        return ModelAndView;
    }


}
