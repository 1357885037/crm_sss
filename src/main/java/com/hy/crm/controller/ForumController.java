package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Forum;
import com.hy.crm.entity.Replys;
import com.hy.crm.entity.Users;
import com.hy.crm.service.IBusinessService;
import com.hy.crm.service.IForumService;
import com.hy.crm.service.IReplysService;
import com.hy.crm.service.IUsersService;
import com.hy.crm.util.AccountJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/crm/forum")
public class ForumController {

    @Autowired
    private IForumService forumService;

    @Autowired
    private IBusinessService businessService;

    @Autowired
    private IReplysService replysService;

    @Autowired
    private IUsersService usersService;


    @ResponseBody
    @RequestMapping("/queryforum.do")
    public AccountJson queryforum( @RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "limit" ,defaultValue = "3")Integer limit,@RequestParam(value = "tiaojian",required = false)Integer tiaojian,@RequestParam(value = "neirong",required = false)String neirong){
        Page pageHelper= PageHelper.startPage(page,limit,true);
        QueryWrapper<Forum> queryWrapper=new QueryWrapper<>();
        if(tiaojian!=null){
        if(tiaojian==1){
            queryWrapper.like("f_title","%"+neirong+"%");
        }
        if(tiaojian==2){
            QueryWrapper<Users> queryWrapper9=new QueryWrapper<>();
            queryWrapper9.like("u_name",neirong);
            List<Users> usersList=usersService.list(queryWrapper9);
            List<Forum> list=new ArrayList<>();
            for(Users users1:usersList){
                queryWrapper.eq("u_id",users1.getU_Id());
                List<Forum> forumList =forumService.list(queryWrapper);
                for(Forum forum:forumList){

                    forum.setU_name(users1.getU_Name());

                    //商机名称

                    QueryWrapper<Business> queryWrapper1=new QueryWrapper<>();
                    queryWrapper1.eq("b_id",forum.getB_id());
                    Business business=businessService.getOne(queryWrapper1);
                    forum.setB_name(business.getB_name());

                    //一级回复人
                    QueryWrapper<Replys> queryWrapper2=new QueryWrapper<>();
                    queryWrapper2.eq("f_id",forum.getF_id());
                    List<Replys> replysList2=replysService.list(queryWrapper2);
                    Integer sum=replysList2.size();
                    for(Replys replys:replysList2){
                        //二级回复人
                        QueryWrapper<Replys> queryWrapper3=new QueryWrapper<>();
                        queryWrapper3.eq("rep_rpid",replys.getRp_id());
                        List<Replys> replysList3=replysService.list(queryWrapper3);
                        sum+=replysList3.size();
                        sum=diedai(replysList3,sum);
                    }

                    forum.setRevert(sum);
                    list.add(forum);
                }


            }

            AccountJson accountJson=new AccountJson();
            accountJson.setCode(0);
            accountJson.setCount(list.size());
            accountJson.setData(list);
            return accountJson;

        }
        if(tiaojian==3){
            queryWrapper.like("f_number",neirong);
        }

        }

        List<Forum> forumList1=new ArrayList<>();

        List<Forum> forumList =forumService.list(queryWrapper);
        for(Forum forum:forumList){

                QueryWrapper<Users> queryWrapper0=new QueryWrapper<>();
                queryWrapper0.eq("u_id",forum.getU_id());
                Users users=usersService.getOne(queryWrapper0);
                forum.setU_name(users.getU_Name());

            //商机名称

            QueryWrapper<Business> queryWrapper1=new QueryWrapper<>();
            queryWrapper1.eq("b_id",forum.getB_id());
            Business business=businessService.getOne(queryWrapper1);
           forum.setB_name(business.getB_name());

           //一级回复人
           QueryWrapper<Replys> queryWrapper2=new QueryWrapper<>();
           queryWrapper2.eq("f_id",forum.getF_id());
            List<Replys> replysList2=replysService.list(queryWrapper2);
            Integer sum=replysList2.size();
            for(Replys replys:replysList2){
                //二级回复人
                QueryWrapper<Replys> queryWrapper3=new QueryWrapper<>();
                queryWrapper3.eq("rep_rpid",replys.getRp_id());
                List<Replys> replysList3=replysService.list(queryWrapper3);
                sum+=replysList3.size();
                sum=diedai(replysList3,sum);
            }

        forum.setRevert(sum);
        if(tiaojian!=null&&tiaojian==4){
            if(Integer.valueOf(neirong).equals(forum.getRevert())){

                forumList1.add(forum);
            }

        }

        }
        AccountJson accountJson=new AccountJson();
        accountJson.setCode(0);
        if(tiaojian!=null&&tiaojian==4) {
            accountJson.setCount(forumList1.size());
        }else{
            accountJson.setCount((int) pageHelper.getTotal());

        }
        if(tiaojian!=null&&tiaojian==4){
            accountJson.setData(forumList1);
        }else{
        accountJson.setData(forumList);}

        return accountJson;
    }

    public Integer diedai(List<Replys> list,Integer sum){
        if(list.size()<=0){
            return sum;
        }else{
            for(Replys replys2:list){
                QueryWrapper<Replys> queryWrapper4=new QueryWrapper<>();
                queryWrapper4.eq("rep_rpid",replys2.getRp_id());
                List<Replys> replysList4=replysService.list(queryWrapper4);
                sum+=replysList4.size();
                sum+=diedai(replysList4,sum);
            }

        }

return sum;

    }

    @ResponseBody
    @RequestMapping("/addForum.do")
    public Integer addForum(Forum forum, HttpSession session, HttpServletResponse response) throws IOException {
        Users users=(Users) session.getAttribute("users");
        forum.setU_id(users.getU_Id());
        java.util.Date d = new java.util.Date();
        System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        forum.setF_date(Date.valueOf( sdf.format(d)));
        forumService.saveOrUpdate(forum);
        return 0;

    }


    @RequestMapping("/updateForum.do")
    public ModelAndView updateForum(String f_id){
        QueryWrapper<Forum> queryWrapper9=new QueryWrapper<>();
        queryWrapper9.eq("f_id",f_id);
        Forum forum2=forumService.getOne(queryWrapper9);
      if(forum2.getF_number()==null||forum2.getF_number().equals("")){
          forum2.setF_number(1);
      }else{
          forum2.setF_number(forum2.getF_number()+1);
      }
        forum2.setF_number(forum2.getF_number()+1);
        forumService.saveOrUpdate(forum2);

        QueryWrapper<Forum> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("f_id",f_id);
        Forum forum3 =forumService.getOne(queryWrapper);
        QueryWrapper<Users> queryWrapper0=new QueryWrapper<>();
        queryWrapper0.eq("u_id",forum3.getU_id());
        Users users=usersService.getOne(queryWrapper0);
        forum3.setU_name(users.getU_Name());

            //商机名称
        QueryWrapper<Business> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.eq("b_id",forum3.getB_id());
        Business business=businessService.getOne(queryWrapper1);
        forum3.setB_name(business.getB_name());

            //一级回复人
        QueryWrapper<Replys> queryWrapper2=new QueryWrapper<>();
        queryWrapper2.eq("f_id",forum3.getF_id());
        List<Replys> replysList2=replysService.list(queryWrapper2);
        Integer sum=replysList2.size();
        for(Replys replys:replysList2){
            //二级回复人
            QueryWrapper<Replys> queryWrapper3=new QueryWrapper<>();
            queryWrapper3.eq("rep_rpid",replys.getRp_id());
            List<Replys> replysList3=replysService.list(queryWrapper3);
            sum+=replysList3.size();
            sum=diedai(replysList3,sum);
            }
        forum3.setRevert(sum);

        ModelAndView modelAndView=new ModelAndView("/page/forum/updateForum.html");
        modelAndView.addObject("forum",forum3);
        return modelAndView;

    }


    @RequestMapping("/addreplys.do")
    public Integer addreplys(Forum forum,HttpSession session){
        System.out.println(forum.toString()+"1111111111111111111111111111111111111111111111111111111111111");
        QueryWrapper<Forum> queryWrapper9=new QueryWrapper<>();
        queryWrapper9.eq("f_id",forum.getF_id());
        Forum forum2=forumService.getOne(queryWrapper9);
        System.out.println(forum2.toString()+"22222222222222222222222222222222222222222222222222222222222");
        java.util.Date d = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        forum2.setR_date(Date.valueOf(sdf.format(d)));
        forumService.saveOrUpdate(forum2);


        QueryWrapper<Replys> queryWrapper=new QueryWrapper<>();
        Replys replys=new Replys();
        Users users=(Users) session.getAttribute("users");
        replys.setU_id(users.getU_Id());
        replys.setF_id(forum.getF_id());
        replys.setRp_text(forum.getF_texts());
        replys.setRp_date(Date.valueOf(sdf.format(d)));
        replys.setRp_statu(0);
        replysService.save(replys);

        return 1;
    }



}
