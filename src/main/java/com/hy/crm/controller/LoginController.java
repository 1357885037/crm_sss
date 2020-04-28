package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Users;
import com.hy.crm.service.ILoginService;
import com.hy.crm.service.impl.LoginServiceImpl;
import com.hy.crm.util.Md5;
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
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

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
@SessionAttributes("user")
public class LoginController {

    static Logger logger=Logger.getLogger(LoginController.class);

    @Autowired
    private ILoginService iLoginService;
    @Autowired
    private LoginServiceImpl loginServiceImol ;

    //登录界面
    @RequestMapping("/login.do")
    @ResponseBody
    public String login(@RequestParam(value = "username") String u_name,@RequestParam(value = "password") String u_pass, Model model,HttpSession session){
        UsernamePasswordToken token=new UsernamePasswordToken(u_name,u_pass); /*令牌*/
        Subject subject =SecurityUtils.getSubject();
        try {
            subject.login(token);
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
        //从数据库中查询
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("u_name",u_name);
        Users users=loginServiceImol.getOne(queryWrapper);
        session.setAttribute("users",users);
        return "1";
    }


    //登录后跳转主界面
    @RequestMapping("/transpond.do")
    public String transpond(String username, Model model,HttpSession session){
        Users user= (Users) session.getAttribute("users");
        model.addAttribute("user",user);
        return "/main_ Interface/index";
    }

    //主界面跳个人资料
    @RequestMapping("/Personal_Data.do")
    public String Personal_Data(HttpSession session, Model model){
        Users users= (Users) session.getAttribute("users");
        //从数据库中查询
        Users user=loginServiceImol.getById(users.getU_Id());
        model.addAttribute("user",user);
        return "page/user/userInfo";
    }

    //注册
   @RequestMapping("/register.do")
   @ResponseBody
   public String register(Users user){
        //判断是否有该用户名
       QueryWrapper queryWrapper=new QueryWrapper();
       queryWrapper.eq("u_name",user.getU_Name());
       Users users=loginServiceImol.getOne(queryWrapper);
       if(users==null){
           //出生年月转换 2020年04月04日转换成 xxxx-xx-xx
           String str=user.getU_Date();
           str=str.replaceAll("年","-").replaceAll("月","-").substring(0,str.length()-1);
           user.setU_Date(str);
           //默认状态
           user.setU_statu(0);
           //默认头像
           user.setU_Img("face.jpg");
           //用户名作为盐值 MD5加密 1024次
           user.setU_pass(Md5.md4Test(user.getU_Name(),user.getU_pass()));
           //添加到数据库
           loginServiceImol.save(user);
           return "1";
       }else{
           return "2";
       }

   }

    //退出页面
    @RequestMapping("/outlogin.do")
    public String outlogin(HttpSession session){
        session.setAttribute("users","");
        return "redirect:/index.html";
    }

}
