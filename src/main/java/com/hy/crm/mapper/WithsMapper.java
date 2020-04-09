package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Withs;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
public interface WithsMapper extends BaseMapper<Withs> {

    //    查询本周新增跟单预计金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE b_id IN(SELECT b_id FROM withs WHERE YEARWEEK(DATE_FORMAT(w_date,'%Y-%m-%d')) = YEARWEEK(NOW()))")
    Double sumMeonkey();

    //    查询上周新增跟单预计金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE b_id IN(SELECT b_id FROM withs WHERE YEARWEEK(DATE_FORMAT(w_date,'%Y-%m-%d')) = YEARWEEK(NOW())-1)")
    Double sumSMeonkey();

    //查询本月新增跟单预计金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE b_id IN(SELECT b_id FROM withs WHERE DATE_FORMAT(w_date,'%Y-%m') = DATE_FORMAT(CURDATE(),'%Y-%m'))")
    Double sumYMeonkey();

    //查询上月新增跟单预计金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE b_id IN(SELECT b_id FROM withs WHERE PERIOD_DIFF(DATE_FORMAT(NOW(),'%Y-%m'),DATE_FORMAT(w_date,'%Y-%m')) = 1)")
    Double sumSYMeonkey();

    //查询本季度新增跟单预计金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE b_id IN(SELECT b_id FROM withs WHERE QUARTER(w_date) = QUARTER(now()))")
    Double sumJdMeonkey();

    //查询上季度新增跟单预计金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE b_id IN(SELECT b_id FROM withs WHERE QUARTER(w_date) = QUARTER(DATE_SUB(NOW(),interval 1 QUARTER)))")
    Double sumSJdMeonkey();

    //查询本年新增跟单预计金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE b_id IN(SELECT b_id FROM withs WHERE YEAR(w_date)=YEAR(NOW()))")
    Double sumNMeonkey();

    //查询上年新增跟单预计金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE b_id IN(SELECT b_id FROM withs WHERE YEAR(w_date)=YEAR(date_sub(NOW(),interval 1 YEAR)))")
    Double sumSNMeonkey();



    //////////////////////////////////////用户跟单预计成交额
    //    查询用户本周新增跟单金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE b_id IN(SELECT b_id FROM withs WHERE YEARWEEK(DATE_FORMAT(w_date,'%Y-%m-%d')) = YEARWEEK(NOW())) AND u_id=#{value}")
    Double UsersumMeonkey(String uid);

    //    查询用户上周新增跟单金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE b_id IN(SELECT b_id FROM withs WHERE YEARWEEK(DATE_FORMAT(w_date,'%Y-%m-%d')) = YEARWEEK(NOW())-1) AND u_id=#{value}")
    Double UsersumSMeonkey(String uid);

    //查询本月新增跟单预计金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE b_id IN(SELECT b_id FROM withs WHERE DATE_FORMAT(w_date,'%Y-%m') = DATE_FORMAT(CURDATE(),'%Y-%m')) AND u_id=#{value}")
    Double UsersumYMeonkey(String uid);

    //查询上月新增跟单预计金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE b_id IN(SELECT b_id FROM withs WHERE PERIOD_DIFF(DATE_FORMAT(NOW(),'%Y-%m'),DATE_FORMAT(w_date,'%Y-%m')) = 1)and u_id=#{value}")
    Double UsersumSYMeonkey(String uid);

    //查询本季度新增跟单预计金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE b_id IN(SELECT b_id FROM withs WHERE QUARTER(w_date) = QUARTER(now())) AND u_id=#{value}")
    Double UsersumJdMeonkey(String uid);

    //查询上季度新增跟单预计金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE b_id IN(SELECT b_id FROM withs WHERE QUARTER(w_date) = QUARTER(DATE_SUB(NOW(),interval 1 QUARTER))) AND u_id=#{value}")
    Double UsersumSJdMeonkey(String uid);

    //查询本年新增跟单预计金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE b_id IN(SELECT b_id FROM withs WHERE YEAR(w_date)=YEAR(NOW())) AND u_id=#{value}")
    Double UsersumNMeonkey(String uid);

    //查询上年新增跟单预计金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE b_id IN(SELECT b_id FROM withs WHERE YEAR(w_date)=YEAR(date_sub(NOW(),interval 1 YEAR))) AND u_id=#{value}")
    Double UsersumSNMeonkey(String uid);


}
