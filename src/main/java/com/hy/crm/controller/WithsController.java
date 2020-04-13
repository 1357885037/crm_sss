package com.hy.crm.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Clients;
import com.hy.crm.entity.Users;
import com.hy.crm.entity.Withs;
import com.hy.crm.service.impl.BusinessServiceImpl;
import com.hy.crm.service.impl.ClientsServiceImpl;
import com.hy.crm.service.impl.WithsServiceImpl;
import com.hy.crm.util.AccountJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
@RequestMapping("/crm/withs")
public class WithsController {

    @Autowired
    WithsServiceImpl withsService;

    @Autowired
    BusinessServiceImpl businessService;

    @Autowired
    ClientsServiceImpl clientsService;

    @RequestMapping("/getById_b_bid.do")
    @ResponseBody
    public AccountJson getById_b_bid(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit, Withs withs, String tiaojian){

        if(tiaojian!=null){
            withs.setStatu(Integer.parseInt(tiaojian));
        }
        System.out.println("1232132141421：：：："+withs.getUser());

        Page pageHelper= PageHelper.startPage(page,limit,true);
        List<Withs> list=withsService.query_ByB_id(withs);
        System.out.println("测。。。。。。"+list.size());
        AccountJson accountJson=new AccountJson();
        accountJson.setCode(0);
        accountJson.setMsg("");
        accountJson.setCount((int) pageHelper.getTotal());
        accountJson.setData(list);

        return accountJson;
    }

    @RequestMapping("/add_withs.do")
    @ResponseBody
    public  String add_withs(Withs withs){
        Business business=businessService.getById(withs.getB_id());
        withs.setW_title(business.getB_name()+"-"+withs.getW_classify());
        System.out.println("=="+withs.toString());
        withs.setU_id("123");
        withsService.save(withs);
        return "1";
    }

    @RequestMapping("/update_withs.do")
    public String redact(String w_id,Model model){
        Withs withs=withsService.getById(w_id);
        Business business=businessService.getById(withs.getB_id());
        Clients clients=clientsService.getById(business.getC_id());
        model.addAttribute("withs",withs);
        model.addAttribute("business",business);
        model.addAttribute("clients",clients);

        return "withs_management/update_withs";
    }

    @RequestMapping("/update_withs2.do")
    @ResponseBody
    public String update(Business business){
        businessService.saveOrUpdate(business);
        return "1";
    }


    @RequestMapping("/getByid_withs.do")
    public String getByid_withs(String b_id, Model model){
        model.addAttribute("b_id",b_id);
        return "business_management/redact_withs";
    }

    @RequestMapping("/add.do")
    public String ccc(HttpSession session,Model model){
        Users user= (Users) session.getAttribute("users");
        model.addAttribute("user",user);
        return "withs_management/add_withs";
    }

    @RequestMapping("/myWihs.do")
    public String myWiths(HttpSession session,Model model){
        Users user= (Users) session.getAttribute("users");
        model.addAttribute("user",user);
        return "withs_management/withs_management";
    }


    @RequestMapping("/sumMeonkey.do")
    @ResponseBody
    public Double sumMeonkey() {
        Double d;
        try {
            d=withsService.sumMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }
    @RequestMapping("/sumSMeonkey.do")
    @ResponseBody
    public Double sumSMeonkey() {
        Double d;
        try {
            d=withsService.sumSMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }
    @RequestMapping("/sumYMeonkey.do")
    @ResponseBody
    public Double sumYMeonkey() {
        Double d;
        try {
            d=withsService.sumYMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }
    @RequestMapping("/sumSYMeonkey.do")
    @ResponseBody
    public Double sumSYMeonkey() {
        Double d;
        try {
            d=withsService.sumSYMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }
    @RequestMapping("/sumJdMeonkey.do")
    @ResponseBody
    public Double sumJdMeonkey() {
        Double d;
        try {
            d=withsService.sumJdMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }
    @RequestMapping("/sumSJdMeonkey.do")
    @ResponseBody
    public Double sumSJdMeonkey() {
        Double d;
        try {
            d=withsService.sumSJdMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
}
    @RequestMapping("/sumNMeonkey.do")
    @ResponseBody
    public Double sumNMeonkey() {
        Double d;
        try {
            d=withsService.sumNMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }
    @RequestMapping("/sumSNMeonkey.do")
    @ResponseBody
    public Double sumSNMeonkey() {
        Double d;
        try {
            d=withsService.sumSNMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

    @RequestMapping("/getByid_forum.do")
    public String getByid_forum(String b_id,Model model){
        model.addAttribute("bb_id",b_id);
        return "page/forum/forum";
    }

}
