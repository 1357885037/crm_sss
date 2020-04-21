package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Users_jurisdictions;
import com.hy.crm.service.IUsers_jurisdictionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/crm/users-jurisdictions")
public class Users_jurisdictionsController {

    @Autowired
    private IUsers_jurisdictionsService users_jurisdictionsService;

    @RequestMapping("/userUpjur.do")
    public ModelAndView userUpjur(String[]  j_id, String u_Id, ModelAndView modelAndView){

        QueryWrapper<Users_jurisdictions> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("u_id",u_Id);
        users_jurisdictionsService.remove(queryWrapper);

        for (int i=0;i<j_id.length;i++){

            Users_jurisdictions jurisdictions=new Users_jurisdictions();
            jurisdictions.setU_id(u_Id);
            jurisdictions.setJ_id(j_id[i]);

            users_jurisdictionsService.save(jurisdictions);

        }
        modelAndView.setViewName("/page/user/queryUsers.html");
        return modelAndView;
    }

}
