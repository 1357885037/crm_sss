package com.hy.crm.dynamic;

import com.hy.crm.entity.Withs;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;

public class Query_Withs {


    public  String query_ByB_id(@Param("withs") Withs withs){
        StringBuffer sql=new StringBuffer(" select * from withs w where 1=1 ");

        if(!StringUtils.isNullOrEmpty(withs.getUser())){
            sql.append(" and w.u_id  = '"+withs.getUser()+"'");
            withs.setUser("");
        }


        if(!StringUtils.isNullOrEmpty(withs.getB_id())){
            sql.append(" and w.b_id = '"+withs.getB_id()+"'");
        }


        if(withs.getStatu()!=null){
            if(withs.getStatu()==1){
                if(!StringUtils.isNullOrEmpty(withs.getW_title())){
                    sql.append(" and w.w_title  like '%"+withs.getW_title()+"%'");
                }
            }

            if(withs.getStatu()==2){
                if(!StringUtils.isNullOrEmpty(withs.getU_id())){
                    sql.append(" and w.u_id  like '%"+withs.getU_id()+"%'");

                }
            }

            if(withs.getStatu()==3){
                if(!StringUtils.isNullOrEmpty(withs.getW_date())){
                    sql.append(" and w.w_date  = '"+withs.getW_date()+"'");

                }

            }

        }





        return sql.toString();
    }
}
