package com.hy.crm.mapper;

import com.hy.crm.entity.Business;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
public interface BusinessMapper extends BaseMapper<Business> {

//    查询本周新增商机金额
@Select("SELECT SUM(b_monkey) FROM business WHERE YEARWEEK(DATE_FORMAT(b_date,'%Y-%m-%d')) = YEARWEEK(NOW())")
Double sumMeonkey();

    //    查询上周新增商机金额
@Select("SELECT SUM(b_monkey) FROM business WHERE YEARWEEK(DATE_FORMAT(b_date,'%Y-%m-%d')) = YEARWEEK(NOW())-1")
Double sumSMeonkey();

//查询本月新增商机金额
@Select("SELECT SUM(b_monkey) FROM business WHERE DATE_FORMAT(b_date,'%Y-%m') = DATE_FORMAT(CURDATE(),'%Y-%m')")
Double sumYMeonkey();

//查询上月新增商机金额
@Select("SELECT SUM(b_monkey) FROM business WHERE PERIOD_DIFF(DATE_FORMAT(NOW(),'%Y-%m'),DATE_FORMAT(b_date,'%Y-%m')) = 1")
Double sumSYMeonkey();

//查询本季度新增商机金额
@Select("SELECT SUM(b_monkey) FROM business WHERE QUARTER(b_date) = QUARTER(now())")
Double sumJdMeonkey();

//查询上季度新增商机金额
@Select("SELECT SUM(b_monkey) FROM business WHERE QUARTER(b_date) = QUARTER(DATE_SUB(NOW(),interval 1 QUARTER))")
Double sumSJdMeonkey();

//查询本年新增商机金额
@Select("SELECT SUM(b_monkey) FROM business WHERE YEAR(b_date)=YEAR(NOW())")
    Double sumNMeonkey();

//查询上年新增商机金额
@Select("SELECT SUM(b_monkey) FROM business WHERE YEAR(b_date)=YEAR(date_sub(NOW(),interval 1 YEAR))")
Double sumSNMeonkey();

///////////////////////////////////根据用户查询商机

//    查询用户本周新增商机金额
@Select("SELECT SUM(b_monkey) FROM business WHERE YEARWEEK(DATE_FORMAT(b_date,'%Y-%m-%d')) = YEARWEEK(NOW())AND u_id=#{value}")
Double UsersumMeonkey(String uid);

    //    查询用户上周新增商机金额
@Select("SELECT SUM(b_monkey) FROM business WHERE YEARWEEK(DATE_FORMAT(b_date,'%Y-%m-%d')) = YEARWEEK(NOW())-1 AND u_id=#{value}")
Double UsersumSMeonkey(String uid);





}
