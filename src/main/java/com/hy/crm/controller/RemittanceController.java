package com.hy.crm.controller;

import com.hy.crm.entity.Checks;
import com.hy.crm.entity.Users;
import com.hy.crm.service.impl.ChecksServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
@Controller
@RequestMapping("/crm/remittance")
public class RemittanceController {

    @Autowired
    ChecksServiceImpl checksService;


    @RequiresPermissions("register_Remittance")
    @RequestMapping("/register_Remittance.do")
    public String register_Remittance(String ct_id, Model model, HttpSession session){
        model.addAttribute("ct_id",ct_id);
        Users users= (Users) session.getAttribute("users");
        model.addAttribute("users",users);
        return "contracts_management/redact_remittance";
    }

    @RequestMapping("/add_Remittance.do")
    @ResponseBody
    public String add_Remittance(Checks checks){
        checksService.save(checks);
        return "1";
    }

}
