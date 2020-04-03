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
    public String login(@RequestParam(value = "username") String u_name,@RequestParam(value = "password") String u_pass, Model model){
        System.out.println("进入方法。。。。。。。。。。。。。。");
        System.out.println(u_name+u_pass);
        //ModelAndView model=new ModelAndView();
        UsernamePasswordToken token=new UsernamePasswordToken(u_name,u_pass); /*令牌*/
        Subject subject =SecurityUtils.getSubject();
        try {
            subject.login(token);
            logger.info("登录成功！");
        }catch (IncorrectCredentialsException ice){
            //捕获密码出现异常
            model.addAttribute("message","密码出现异常");
            System.out.println(subject.isAuthenticated());
            return  "1";
        }catch (UnknownAccountException uae){
            //捕获未知用户名异常
            model.addAttribute("message","用户名出现异常");
             System.out.println("222");
            return  "2";
        }catch (ExcessiveAttemptsException eae){
            //捕获错误登录多次的异常
            model.addAttribute("message","错误登录多次");
            return  "3";
        }
System.out.println("sssssssssssssssssssssssssssss");
        return "/index";
    }

    @RequestMapping("/Login/Users/aaa.do")
    public String aaa(){
        System.out.println("进行中---------------------------------");
        return "login.html";
    }


}
