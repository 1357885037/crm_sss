package com.hy.crm.controller;

import com.hy.crm.service.impl.LoginServiceImpl;
import com.hy.crm.service.ILoginService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mq
 * @since 2020-03-24
 */
@Controller
@RequestMapping("/Login/Users")
public class LoginController {

    static Logger logger=Logger.getLogger(LoginController.class);
    @Autowired
    private ILoginService iLoginService;
    @Autowired
    private LoginServiceImpl loginServiceImol ;

    @RequestMapping("/login.do")
    @ResponseBody
    public String login(@RequestParam(value = "username") String u_name,@RequestParam(value = "password") String u_pass, Model model){
        System.out.println("进入方法。。。。。。。。。。。。。。");
        System.out.println(u_name+u_pass);
        //ModelAndView model=new ModelAndView();
        UsernamePasswordToken token=new UsernamePasswordToken(u_name,u_pass); /*令牌*/
        Subject subject =SecurityUtils.getSubject();
        try {
            subject.login(token);
            logger.info("登录成功！");
        }catch (UnknownAccountException uae){
            //捕获未知用户名异常
            return  "2";
        }catch (IncorrectCredentialsException ice){
            //捕获密码出现异常
            return  "3";
        }catch (ExcessiveAttemptsException eae){
            //捕获错误登录多次的异常
            return  "4";
        }
        return "1";
    }

    @RequestMapping("/Login/Users/aaa.do")
    public String aaa(){
        System.out.println("进行中---------------------------------");
        return "login.html";
    }

    @RequestMapping("/transpond.do")
    public String transpond(String username,Model model){
        model.addAttribute("user",username);
        return "/main_ Interface/index";
    }
}
