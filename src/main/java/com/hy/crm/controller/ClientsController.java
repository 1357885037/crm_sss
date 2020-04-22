package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crm.entity.*;
import com.hy.crm.mapper.ClientsMapper;
import com.hy.crm.service.impl.BusinessServiceImpl;
import com.hy.crm.service.impl.Client_financeServiceImpl;
import com.hy.crm.service.impl.ClientsServiceImpl;
import com.hy.crm.util.AccountJson;
import com.hy.crm.util.Md5;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@RequestMapping("/crm/clients")
public class ClientsController {

    @Autowired
    ClientsServiceImpl clientsService;

    @Autowired
    Client_financeServiceImpl client_financeService;

    @Autowired
    BusinessServiceImpl businessService;

    @Autowired
    ClientsMapper clientsMapper;

    @RequestMapping("/queryall.do")
    @ResponseBody
    public AccountJson queryall(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit,String tiaojian,Clients clients){

        if(tiaojian!=null){
            clients.setStatu(Integer.parseInt(tiaojian));
        }

        Page pageHelper= PageHelper.startPage(page,limit,true);
        List<Customer_management> list=clientsService.customer_managements(clients);

        AccountJson accountJson=new AccountJson();
        accountJson.setCode(0);
        accountJson.setMsg("");
        accountJson.setCount((int) pageHelper.getTotal());
        accountJson.setData(list);

        return accountJson;
    }

    @RequestMapping("/addClients.do")
    @ResponseBody
    public String addClients(Clients clients, Client_finance client_finance){
        QueryWrapper<Clients> queryWrapper=new QueryWrapper();
        queryWrapper.eq("c_name",clients.getC_name());
        Clients clients1=clientsService.getOne(queryWrapper);
        if (clients1!=null){
            return "2";
        }else{
             clientsService.save(clients);
            //add进去重新查询获取uuid 赋值给客户财务信息表
            QueryWrapper<Clients> queryWrapper2=new QueryWrapper();
            queryWrapper.eq("c_name",clients.getC_name());
            Clients clients2=clientsService.getOne(queryWrapper);

            client_finance.setC_id(clients.getC_id());
            //add财务信息表
            client_financeService.save(client_finance);

          return "1";
        }
    }

    /*客户修改*/
    @RequiresPermissions("clients:update")
    @RequestMapping("/redact.do")
    public String redact(String c_id, Model model){
        Clients clients=clientsService.getById(c_id);
        Client_finance client_finance=client_financeService.getbyc_id(c_id);

        model.addAttribute("clients",clients);
        model.addAttribute("client_finance",client_finance);
        return "customer_management/redact_clients";
    }

    @RequestMapping("/update_Clients.do")
    @ResponseBody
    public String update_Clients(Clients clients,Client_finance client_finance){
        clientsService.updateById(clients);
        client_financeService.updateByC_id(client_finance);

        return "1";
    }

    //删除暂时关闭
    @RequestMapping("/delete_Clients.do")
    @ResponseBody
    public String deleteByid(String c_id){
      /*  client_financeService.removeById(c_id);
        clientsService.removeById(c_id);*/
        return "1";
    }

    @RequiresPermissions("business:select")
    @RequestMapping("/customer_contract.do")
    public String customer_contract(String c_id,Model model){
        model.addAttribute("c_id",c_id);
        return "customer_management/customer_contract";
    }

    @RequestMapping("/customer_contract2.do")
    @ResponseBody
    public AccountJson customer_contract2(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit,Model model, Business business){
       Page pageHelper= PageHelper.startPage(page,limit,true);
       List<Customer_contract> list=clientsService.customer_contract(business);
        AccountJson accountJson=new AccountJson();
        accountJson.setCode(0);
        accountJson.setMsg("");
        accountJson.setCount((int) pageHelper.getTotal());
        accountJson.setData(list);
        return accountJson;
    }

    @RequiresPermissions("contracts:select")
    @RequestMapping("/customer_contractsss.do")
    public String customer_contractsss(String c_id,Model model){
        model.addAttribute("c_id",c_id);
        Users users=new Users();
        model.addAttribute("users",users);
        return "contracts_management/contracts_management";
    }

    @RequiresPermissions("business:update")
    @RequestMapping("/getByid_business.do")
    public String getByid_business(String b_id,Model model){
        Business business=businessService.getById(b_id);
        model.addAttribute("business",business);
        return "customer_management/redact_business";
    }


    @RequestMapping("/Sumclients.do")
    @ResponseBody
    public Integer Sumclients(){
        Integer i=0;
        try {
            QueryWrapper<Clients> queryWrapper=new QueryWrapper<>();
            i=clientsService.count(queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @RequestMapping("/customer_serves.do")
    public String customer_serves(String c_id, Model model){
        model.addAttribute("c_id",c_id);
        return "page/serve/serves";
    }


    @ResponseBody
    @RequestMapping("/querygroup.do")
    public List<Eachtes> querygroup(){

        return clientsService.queryccc();
    }


    @ResponseBody
    @RequestMapping("/getpass.do")
    public String getpass(HttpSession session,String test,String u_name){
        String pass=Md5.md4Test(u_name,test);
        return pass;
    }
}
