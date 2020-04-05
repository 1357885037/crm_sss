package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Forum;
import com.hy.crm.service.IForumService;
import com.hy.crm.util.AccountJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/crm/forum")
public class ForumController {

    @Autowired
    private IForumService forumService;

    @ResponseBody
    @RequestMapping("/queryforum.do")
    public AccountJson queryforum( @RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit" ,defaultValue = "3")Integer limit){

        QueryWrapper<Forum> queryWrapper=new QueryWrapper<>();
        List<Forum> forumList =forumService.list(queryWrapper);
        AccountJson accountJson=new AccountJson();
        accountJson.setCode(0);
        accountJson.setCount(forumList.size());
        accountJson.setData(forumList);
        return accountJson;
    }

}
