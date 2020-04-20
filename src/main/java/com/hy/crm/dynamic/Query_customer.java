package com.hy.crm.dynamic;

import com.hy.crm.entity.Business;
import com.hy.crm.entity.Clients;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;

public class Query_customer {


   // @Select("select c.c_id c_id,c.c_name c_name,(select count(*) from business b where b.c_id=c.c_id )  business_count,(select sum(b.b_monkey) from business b where b.c_id=c.c_id )  turnover,(select count(*) from contracts ct  where ct.b_id=(select b.b_id from business b where b.c_id=c.c_id)) contract_count,(select sum(ct_monkey) from contracts ct ,business b where ct.b_id=(select b.b_id from business b where b.c_id=c.c_id)) contract_amount,(select sum(re_monkey) from  remittance re where re.ct_id=(select ct.ct_id from contracts ct ,business b where ct.b_id=(select b.b_id from business b where b.c_id=c.c_id)  )) total_Return_amount ,(select count(*) from serves s where s.ct_id=(select ct.ct_id from contracts ct ,business b where ct.b_id=(select b.b_id from business b where b.c_id=c.c_id)   )) service_count ,(select avg(s_grade) from serves s  where s.ct_id=(select ct.ct_id from contracts ct ,business b where ct.b_id=(select b.b_id from business b where b.c_id=c.c_id) )) servic_Score   from  clients c , business b")

    public String query(@Param("clients") Clients clients){
        System.out.println("进来狗子。.....");
        StringBuffer sql=new StringBuffer(" select  c.c_id c_id,c.c_name c_name,(select count(*) from business b where b.c_id=c.c_id )  business_count ,(select sum(b.b_monkey) from business b where b.c_id=c.c_id )  turnover ,(select count(*) from contracts ct  where ct.c_id =c.c_id) contract_count,(select sum(ct_monkey) from contracts ct   where ct.c_id = c.c_id) contract_amount,(select sum(re_monkey) from  remittance re where re.ct_id in (select ct.ct_id from contracts ct   where ct.c_id = c.c_id  )) total_Return_amount ,(select count(*) from serves s where s.ct_id in (select ct.ct_id from contracts ct   where ct.c_id =c.c_id  )) service_count ,(select avg(s_grade) from serves s  where s.ct_id in (select ct.ct_id from contracts ct   where ct.c_id = c.c_id )) servic_Score   from clients c where 1=1 ");


        if(clients.getStatu()!=null){
         System.out.println("二狗子");
            //根据客户名称查询
            if(clients.getStatu()==1){
                if(!StringUtils.isNullOrEmpty(clients.getC_name())){
                    sql.append(" and c.c_name like '%"+clients.getC_name()+"%'");
                }
            }

            //根据客户来源
            if(clients.getStatu()==2){
                if(!StringUtils.isNullOrEmpty(clients.getC_source())){
                    sql.append(" and c.c_source like '%"+clients.getC_source()+"%'");
                }
            }

            //根据国家地区
            if(clients.getStatu()==3){
                if(!StringUtils.isNullOrEmpty(clients.getC_state())){
                    sql.append(" and c.c_state like '%"+clients.getC_state()+"%'");
                }
            }

            //按所在城市
            if(clients.getStatu()==4){
                if(!StringUtils.isNullOrEmpty(clients.getC_city())){
                    sql.append(" and c.c_city like '%"+clients.getC_city()+"%'");
                }
            }

            //按所属行业
            if(clients.getStatu()==5){
                if(!StringUtils.isNullOrEmpty(clients.getC_industry())){
                    sql.append(" and c.c_industry like '%"+clients.getC_industry()+"%'");
                }
            }

        }

        if(clients.getC_classify()!=null){
                  sql.append(" and c.c_classify = '"+clients.getC_classify()+"' ");
        }

        return sql.toString();
    }

    public String query_Contract(@Param("business") Business business){
        System.out.println("进来狗子。.....");
        StringBuffer sql=new StringBuffer("select b.b_id,b.b_name,b_stage,b_monkey,(select u_realname from users u where u.u_id=b.u_id) u_realname ,(select max(w_date) from withs w where w.b_id=b.b_id)  w_date ,(select count(*) from forum f where f.b_id=b.b_id)  forum_count from business b where 1=1");

        if(!StringUtils.isNullOrEmpty(business.getUu_id())){
            sql.append(" and b.u_id = '"+business.getUu_id()+"'");
        }

        if(!StringUtils.isNullOrEmpty(business.getC_id())){
            sql.append(" and b.c_id = '"+business.getC_id()+"'");
        }

        if(!StringUtils.isNullOrEmpty(business.getB_name())){
            sql.append(" and b.b_name like '%"+business.getB_name()+"%'");
        }

        if(!StringUtils.isNullOrEmpty(business.getB_stage())){
            sql.append(" and b.b_stage = '"+business.getB_stage()+"'");
        }


        if(!StringUtils.isNullOrEmpty(business.getU_id())){
            sql.append(" and b.u_id = '"+business.getU_id()+"'  ");
        }

        if(!StringUtils.isNullOrEmpty(business.getB_date())){
            sql.append(" and b.b_date = '"+business.getB_date()+"'  ");
        }

       /* if(!StringUtils.isNullOrEmpty(business.getB_stage())){
            System.out.println("sssssssssssssss");
            if(business.getB_stage().equals("0")){
                System.out.println("bbbbbbbbbbbbbbbb");
                sql.append(" and b.b_stage not in ('成交','丢单','搁置')  ");
            }
        }*/

        if(business.getStatu()!=null){
            //进行中的商机
            if(business.getStatu()==0){
                sql.append(" and b.b_stage not in ('成交','丢单','搁置')  ");
            }

            //7天为跟单
            if(business.getStatu()==1){
                sql.append(" and   date_sub(curdate(), interval 7 day) <= date((select max(w_date) from withs w where w.b_id=b.b_id) )  ");
            }
            //30天未跟单
            if(business.getStatu()==2){
                sql.append(" and   date_sub(curdate(), interval 30 day) <= date((select max(w_date) from withs w where w.b_id=b.b_id) )  ");
            }
            //90天为跟单
            if(business.getStatu()==3){
                sql.append(" and   date_sub(curdate(), interval 90 day) <= date((select max(w_date) from withs w where w.b_id=b.b_id) )  ");
            }
            //本周新增
            if(business.getStatu()==4){
                sql.append(" and b.b_current_time between current_date()-7 and sysdate()  ");
            }

            //上周新增
            if(business.getStatu()==5){
                sql.append(" and YEARWEEK(date_format(b.b_current_time ,'%Y-%m-%d')) = YEARWEEK(now())-1 ");
            }
            //本月新增
            if(business.getStatu()==6){
                sql.append(" and DATE_FORMAT( b.b_current_time, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )");
            }
            //上月新增
            if(business.getStatu()==7){
                sql.append(" and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format( b.b_current_time, '%Y%m' ) ) =1 ");
            }
            //本季度新增
            if(business.getStatu()==8){
                sql.append(" and  QUARTER(b.b_current_time)=QUARTER(now()) ");
            }

            //上季度新增
            if(business.getStatu()==9){
                sql.append(" and  QUARTER(b.b_current_time)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) ");
            }

            //已成交的商机
            if(business.getStatu()==10){
                sql.append(" and b.b_stage='成交' ");
            }
            //已丢单的商机
            if(business.getStatu()==11){
                sql.append(" and b.b_stage='丢单' ");
            }
            //已搁置的商机
            if(business.getStatu()==12){
                sql.append(" and b.b_stage='搁置' ");
            }

            //已关注
            if(business.getStatu()==13){
                StringBuffer sql2=new StringBuffer("select b.b_id,b.b_name,b_stage,b_monkey,(select u_realname from users u where u.u_id=b.u_id) u_realname ,(select max(w_date) from withs w where w.b_id=b.b_id)  w_date ,(select count(*) from forum f where f.b_id=b.b_id)  forum_count from business b where 1=1");
                sql2.append(" and b.use_attention like '%"+business.getUu_id()+"%'");
              return sql2.toString();
            }

            //参与
            if(business.getStatu()==14){
                StringBuffer sql2=new StringBuffer("select b.b_id,b.b_name,b_stage,b_monkey,(select u_realname from users u where u.u_id=b.u_id) u_realname ,(select max(w_date) from withs w where w.b_id=b.b_id)  w_date ,(select count(*) from forum f where f.b_id=b.b_id)  forum_count from business b where 1=1");
                sql2.append(" and b.u_participation like '%"+business.getUu_id()+"%'");
                return sql2.toString();
            }
        }

        return sql.toString();
    }


}
