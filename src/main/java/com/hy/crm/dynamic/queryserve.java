package com.hy.crm.dynamic;

import com.hy.crm.entity.Serves;
import org.apache.ibatis.annotations.Param;

public class queryserve {
//    NNER JOIN contracts c ON a.ct_id=c.ct_id
    public String query(@Param("serves") Serves serves){
        StringBuffer sql=new StringBuffer("SELECT * FROM serves where 1=1 ");

        if (serves.getS_theme()!=null && serves.getS_theme()!="null" && !serves.getS_theme().equals("null") && serves.getS_theme()!="") {
            sql.append(" and s_theme = "+serves.getS_theme()+"");
        }
        if (serves.getS_sdate()!=null && serves.getS_sdate()!="null" && !serves.getS_sdate().equals("null") && serves.getS_sdate()!="") {
            sql.append(" and s_sdate = "+serves.getS_sdate()+"");
        }
        if (serves.getS_type()!=null && serves.getS_type()!="null" && !serves.getS_type().equals("null") && serves.getS_type()!="") {
            sql.append(" and s_type = "+serves.getS_type()+"");
        }
        if (serves.getS_name()!=null && serves.getS_name()!="null" && !serves.getS_name().equals("null") && serves.getS_name()!="") {
            sql.append(" and s_name like '%"+serves.getS_name()+"%'");
        }
        if (serves.getS_grade()!=null ) {
            sql.append(" and s_grade = "+serves.getS_grade()+"");
        }

        return sql.toString();
    }


}
