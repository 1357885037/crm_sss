package com.hy.crm.controller;

import com.hy.crm.entity.Users;
import com.hy.crm.service.IUsersService;
import com.hy.crm.util.Ajax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/crm/upload")
public class loadController {

    @Autowired
    private IUsersService iUsersService;

    @ResponseBody
    @RequestMapping("/fileUpload.do")
    public Ajax fileUpload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request, Ajax ajax){
        int a=0;
        // 图片上传
// 设置图片名称，不能重复，可以使用uuid//意思为产生一个随机的名字
        String picName = UUID.randomUUID().toString();
// 获取文件名
        String oriName = multipartFile.getOriginalFilename();
// 获取图片(文件名)后缀
        String extName = oriName.substring(oriName.lastIndexOf("."));
        try {
            multipartFile.transferTo(new File(  request.getSession().getServletContext().getRealPath("/")+"/images/"+ picName + extName));
        } catch (IOException e) {
            e.printStackTrace();
            a=1;
        }
        ajax.setCode(a);
        ajax.setFilename(picName+extName);
        return ajax;
    }

    @ResponseBody
    @RequestMapping("/userUpload.do")
    public Ajax userUpload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request, Ajax ajax, HttpSession session){
        int a=0;
        // 图片上传
// 设置图片名称，不能重复，可以使用uuid//意思为产生一个随机的名字
        String picName = UUID.randomUUID().toString();
// 获取文件名
        String oriName = multipartFile.getOriginalFilename();
// 获取图片(文件名)后缀
        String extName = oriName.substring(oriName.lastIndexOf("."));
        try {
            multipartFile.transferTo(new File(  request.getSession().getServletContext().getRealPath("/")+"/images/"+ picName + extName));
        } catch (IOException e) {
            e.printStackTrace();
            a=1;
        }
        Users users=(Users) session.getAttribute("users");
        users.setU_Img(picName+extName);
        boolean b=iUsersService.saveOrUpdate(users);




        ajax.setCode(a);
        ajax.setFilename(picName+extName);
        return ajax;
    }

}
