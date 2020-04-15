package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Jurisdictions;
import com.hy.crm.entity.Roles;
import com.hy.crm.entity.Roles_jurisdiction;
import com.hy.crm.service.IJurisdictionsService;
import com.hy.crm.service.IRolesService;
import com.hy.crm.service.IRoles_jurisdictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
@RequestMapping("/crm/roles-jurisdiction")
public class Roles_jurisdictionController {

    @Autowired
    private IJurisdictionsService jurisdictionsService;

    @Autowired
    private IRoles_jurisdictionService iRolesJurisdictionService;

    @Autowired
    private IRolesService rolesService;

    @RequestMapping("/queryroles.do")
    public ModelAndView queryroles(ModelAndView modelAndView, String r_id){

        QueryWrapper<Jurisdictions> queryWrapper=new QueryWrapper<>();
        queryWrapper.isNull("jur_jid");
        List<Jurisdictions> jurisdictionsList=jurisdictionsService.list(queryWrapper);

        for (Jurisdictions jurisdictions:jurisdictionsList){
            QueryWrapper<Jurisdictions> queryWrapper2=new QueryWrapper<>();
            queryWrapper2.eq("jur_jid",jurisdictions.getJ_id());
          List<Jurisdictions>  jurisdictions2=jurisdictionsService.list(queryWrapper2);
            jurisdictions.setJurisdictionsList(jurisdictions2);

        }

        QueryWrapper<Roles_jurisdiction> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.eq("r_id",r_id);
       List<Roles_jurisdiction> rolesJurisdictions=iRolesJurisdictionService.list(queryWrapper1);

        QueryWrapper<Roles> queryWrapper2=new QueryWrapper<>();
        queryWrapper2.eq("r_id",r_id);
        Roles roles=rolesService.getOne(queryWrapper2);
        for (Jurisdictions jurisdictions:jurisdictionsList){
            for (Roles_jurisdiction rolesJurisdiction:rolesJurisdictions){
                if(jurisdictions.getJ_id().equals(rolesJurisdiction.getJ_id())){
                    jurisdictions.setStatus(1);
                    break;
                }else{
                    jurisdictions.setStatus(2);
                }

            }

            for (Jurisdictions jurisdictions1:jurisdictions.getJurisdictionsList()){
                for (Roles_jurisdiction rolesJurisdiction:rolesJurisdictions){
                    if(jurisdictions1.getJ_id().equals(rolesJurisdiction.getJ_id())){
                        jurisdictions1.setStatus(1);
                        break;
                    }else{
                        jurisdictions1.setStatus(2);
                    }

                }

            }

        }
        modelAndView.addObject("jurisdictionsList",jurisdictionsList);
        modelAndView.addObject("r_id",r_id);
        modelAndView.addObject("r_name",roles.getR_name());
        modelAndView.setViewName("page/user/rolesaddjursdiction.html");

        return modelAndView;
    }


    @RequestMapping("/updaterolejursdiction.do")
    public ModelAndView updaterolejursdiction(String r_id,String[] j_id,ModelAndView modelAndView){

        QueryWrapper<Roles_jurisdiction> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("r_id",r_id);
        iRolesJurisdictionService.remove(queryWrapper);

        for (int i=0;i<j_id.length;i++){

            Roles_jurisdiction rolesJurisdiction=new Roles_jurisdiction();
            rolesJurisdiction.setR_id(r_id);
            rolesJurisdiction.setJ_id(j_id[i]);
            iRolesJurisdictionService.save(rolesJurisdiction);

        }
        modelAndView.setViewName("page/user/gRoles.html");
        return modelAndView;
    }

}
