package com.hy.crm.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crm.entity.Serves;
import com.hy.crm.service.IServesService;
import com.hy.crm.util.AccountJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
@Controller
@RequestMapping("/crm/serves")
public class ServesController {
    @Autowired
    private IServesService servesService;

    @ResponseBody
    @RequestMapping("/queryAllServe.do")
    public AccountJson queryAllServe(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit",defaultValue = "3")Integer limit,Serves serves,@RequestParam(value = "tiaojian",required = false)Integer tiaojian,@RequestParam(value = "neirong",required = false)String neirong){
      if(tiaojian !=null) {
          if (tiaojian == 1) {
              serves.setS_theme(neirong);
          } else if (tiaojian == 2) {
              serves.setS_odate(neirong);
          } else if (tiaojian == 3) {
              serves.setS_name(neirong);
          } else if (tiaojian == 4) {
              serves.setS_type(neirong);
          } else if (tiaojian == 5) {
              serves.setS_grade(Integer.valueOf(neirong));
          }
      }

       Page pageHelper= PageHelper.startPage(page,limit,true);
       List<Serves> servesList = servesService.pages(serves);
        AccountJson accountJson=new AccountJson();
        accountJson.setCode(0);
        accountJson.setMsg("");
        accountJson.setCount((int) pageHelper.getTotal());
        accountJson.setData(servesList);
        return accountJson;
    }

    @RequestMapping("/addsever.do")
    public void addsever(Serves serves, HttpServletResponse response) throws IOException {
        String uuid = UUID.randomUUID().toString();
        serves.setS_id(uuid);
        serves.setS_statu(0);
        servesService.save(serves);
        response.sendRedirect("/page/serve/serves.html");
    }

}
