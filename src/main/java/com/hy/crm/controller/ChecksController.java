package com.hy.crm.controller;

import com.hy.crm.entity.Remittance;
import com.hy.crm.entity.Users;
import com.hy.crm.service.impl.RemittanceServiceImpl;
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
@RequestMapping("/crm/checks")
public class ChecksController {

    @Autowired
    RemittanceServiceImpl remittanceService;

    //收入登记
    @RequestMapping("/register_checks.do")
    public String register_checks(String ct_id, Model model,HttpSession session){
        Users users= (Users) session.getAttribute("users");
        model.addAttribute("ct_id",ct_id);
        model.addAttribute("users",users);
        return "contracts_management/register_checks";
    }

    @RequestMapping("/adds_checks.do")
    @ResponseBody
    public String adds_checks(Remittance remittance){
        remittanceService.save(remittance);
        return "1";
    }

}
