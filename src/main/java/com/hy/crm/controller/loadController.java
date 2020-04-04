package com.hy.crm.controller;

import com.hy.crm.util.Ajax;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/crm/upload")
public class loadController {

    @ResponseBody
    @RequestMapping("/fileUpload.do")
    public Ajax fileUpload(@RequestParam("s_accessory") MultipartFile multipartFile, HttpServletRequest request, Ajax ajax){
        System.out.println("加油进来了！！！！！！！！！！！！！！！！！！！！！！！！");

        int a=0;
        // 图片上传
// 设置图片名称，不能重复，可以使用uuid//意思为产生一个随机的名字
        String picName = UUID.randomUUID().toString();
// 获取文件名
        String oriName = multipartFile.getOriginalFilename();
// 获取图片(文件名)后缀
        String extName = oriName.substring(oriName.lastIndexOf("."));
        try {
            multipartFile.transferTo(new File( request.getSession().getServletContext().getRealPath("/")+"/load/"+ picName + extName));
        } catch (IOException e) {
            e.printStackTrace();
            a=1;
        }
        ajax.setCode(a);
        ajax.setFilename(picName+extName);
        return ajax;
    }

}
