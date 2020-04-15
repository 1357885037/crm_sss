package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Roles;
import com.hy.crm.service.IRolesService;
import com.hy.crm.util.AccountJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/crm/roles")
public class RolesController {

    @Autowired
    private IRolesService rolesService;


    @RequestMapping("/queryRoles.do")
    public AccountJson queryRoles(AccountJson accountJson){
        QueryWrapper<Roles> queryWrapper=new QueryWrapper<>();
        List<Roles> rolesList=rolesService.list(queryWrapper);
        accountJson.setCode(0);
        accountJson.setData(rolesList);

        return accountJson;
    }

    @RequestMapping("/addroles.do")
    public Integer addroles(Roles roles,String r_name){
        Integer num=1;
        roles.setR_id(UUID.randomUUID().toString());
        roles.setR_name(r_name);
        try {
            rolesService.save(roles);
        } catch (Exception e) {
            num=2;
        }

        return num;
    }

}
