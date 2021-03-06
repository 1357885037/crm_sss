package com.hy.crm.dynamic;

import com.hy.crm.entity.Clients;
import com.hy.crm.entity.Contracts;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;

public class Query_contracts {


    public String query(@Param("contracts") Contracts contracts,@Param("clients") Clients clients){

        StringBuffer sql=new StringBuffer("select *,(select sum(re_monkey) from remittance r where r.ct_id=ct.ct_id )  re_monkey ,(select sum(ch_monkey) from checks ch where ch.ct_id=ct.ct_id)  ch_monkey  from  contracts ct  ,clients c where ct.c_id=c.c_id");

            if(!StringUtils.isNullOrEmpty(contracts.getC_id())){
                sql.append(" and ct.c_id = '"+contracts.getC_id()+"' ");
            }

            if(!StringUtils.isNullOrEmpty(contracts.getU_id())){
                sql.append(" and ct.u_id = '"+contracts.getU_id()+"' ");
            }

            if(contracts.getCt_status()!=null && contracts.getCt_status()<4 ){
                sql.append(" and ct.ct_status = '"+contracts.getCt_status()+"' ");
            }

            //本周新增
            if(contracts.getCt_status()!=null && contracts.getCt_status()==4){
                sql.append(" and ct.ct_qddate between current_date()-7 and sysdate()  ");
            }
            //上周新增
            if(contracts.getCt_status()!=null && contracts.getCt_status()==5){
                sql.append(" and YEARWEEK(date_format(ct.ct_qddate ,'%Y-%m-%d')) = YEARWEEK(now())-1 ");
            }

            //本月新增
            if(contracts.getCt_status()!=null && contracts.getCt_status()==6){
                sql.append(" and DATE_FORMAT(ct.ct_qddate, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )");
            }

            //上月新增
            if(contracts.getCt_status()!=null && contracts.getCt_status()==7){
                sql.append(" and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format( ct.ct_qddate, '%Y%m' ) ) =1 ");
            }

            //本季度新增
            if(contracts.getCt_status()!=null && contracts.getCt_status()==8){
                sql.append(" and  QUARTER(ct.ct_qddate)=QUARTER(now()) ");
            }

            //上季度新增
            if(contracts.getCt_status()!=null && contracts.getCt_status()==9){
                sql.append(" and  QUARTER(ct.ct_qddate)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) ");
            }

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

        return sql.toString();
    }


}
