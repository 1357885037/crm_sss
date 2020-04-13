package com.hy.crm.dynamic;

import com.hy.crm.entity.Serves;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;

public class queryserve {
    public String query(@Param("serves") Serves serves){

        StringBuffer sql=new StringBuffer("SELECT s.*,c.ct_id,c.ct_name FROM serves s INNER JOIN contracts c ON s.ct_id=c.ct_id where 1=1 ");

        //根据 c_id查询当前客户底下所有的售后   '"+serves.getC_id()+"'
        if(!StringUtils.isNullOrEmpty(serves.getC_id())){
            sql.append(" and s.ct_id in ( select ct_id from contracts where c_id = '"+serves.getC_id()+"'  ) ");
        }

        //      根据主题
        if (serves.getS_theme()!=null && serves.getS_theme()!="null" && !serves.getS_theme().equals("null") && serves.getS_theme()!="") {
            sql.append(" and s.s_theme like '%"+serves.getS_theme()+"%'");
        }
//        根据开始时间
        if (serves.getS_sdate()!=null && serves.getS_sdate()!="null" && !serves.getS_sdate().equals("null") && serves.getS_sdate()!="") {
            sql.append(" and s.s_sdate = '"+serves.getS_sdate()+"'");
        }
//        根据服务类型
        if (serves.getS_type()!=null && serves.getS_type()!="null" && !serves.getS_type().equals("null") && serves.getS_type()!="") {
            sql.append(" and s.s_type = '"+serves.getS_type()+"'");
        }
//        根据服务人
        if (serves.getS_name()!=null && serves.getS_name()!="null" && !serves.getS_name().equals("null") && serves.getS_name()!="") {
            sql.append(" and s.s_name like '%"+serves.getS_name()+"%'");
        }
//        根据评分
        if (serves.getS_grade()!=null) {
            sql.append(" and s.s_grade = '"+serves.getS_grade()+"'");
        }
        //根据状态
        if (serves.getS_statu()!=null&&!serves.getS_statu().equals("") ) {
            sql.append(" and s.s_statu = "+serves.getS_statu()+"");
        }
        //本周
        if (serves.getB()!=null&&!serves.getB().equals("")&&serves.getB()==1) {
            sql.append(" and YEARWEEK(DATE_FORMAT(s.s_sdate,'%Y-%m-%d')) = YEARWEEK(NOW())");
        }
        //上周
        if (serves.getB()!=null&&!serves.getB().equals("") &&serves.getB()==2) {
            sql.append(" and YEARWEEK(DATE_FORMAT(s.s_sdate,'%Y-%m-%d')) = YEARWEEK(NOW())-1");
        }
//        本月
        if (serves.getB()!=null&&!serves.getB().equals("")&&serves.getB()==3 ) {
            sql.append(" and DATE_FORMAT(s.s_sdate,'%Y-%m') = DATE_FORMAT(CURDATE(),'%Y-%m')");
        }
        //上月
        if (serves.getB()!=null&&!serves.getB().equals("")&&serves.getB()==4 ) {
            sql.append(" and PERIOD_DIFF(DATE_FORMAT(NOW(),'%Y-%m'),DATE_FORMAT(s.s_sdate,'%Y-%m')) = 1");
        }
//        本季度
        if (serves.getB()!=null&&!serves.getB().equals("")&&serves.getB()==5 ) {
            sql.append(" and QUARTER(s.s_sdate) = QUARTER(now())");
        }
//        上季度
        if (serves.getB()!=null&&!serves.getB().equals("")&&serves.getB()==6 ) {
            sql.append(" and QUARTER(s.s_sdate) = QUARTER(DATE_SUB(NOW(),interval 1 QUARTER))");
        }


System.out.println(sql.toString());
        return sql.toString();
    }


    }
