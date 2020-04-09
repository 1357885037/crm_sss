package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Business;
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
//所有钱
   @Select("select sum(b_monkey) from business where b_code=1")
    String countMeonkey();

   @Select("select sum(b_monkey) from business where b_code=2")
   String codemonkey2();

    @Select("select sum(b_monkey) from business where b_code=3")
    String codemonkey3();

    @Select("select sum(b_monkey) from business where b_code=4")
    String codemonkey4();

    @Select("select sum(b_monkey) from business where b_code=5")
    String codemonkey5();


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
@Select("SELECT SUM(b_monkey) FROM business WHERE YEARWEEK(DATE_FORMAT(b_date,'%Y-%m-%d')) = YEARWEEK(NOW()) AND u_id=#{value}")
Double UsersumMeonkey(String uid);

    //    查询用户上周新增商机金额
@Select("SELECT SUM(b_monkey) FROM business WHERE YEARWEEK(DATE_FORMAT(b_date,'%Y-%m-%d')) = YEARWEEK(NOW())-1 AND u_id=#{value}")
Double UsersumSMeonkey(String uid);

    //查询用户本月新增商机金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE DATE_FORMAT(b_date,'%Y-%m') = DATE_FORMAT(CURDATE(),'%Y-%m') AND u_id=#{value}")
    Double UsersumYMeonkey(String uid);

    //查询用户上月新增商机金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE PERIOD_DIFF(DATE_FORMAT(NOW(),'%Y-%m'),DATE_FORMAT(b_date,'%Y-%m')) = 1 AND u_id=#{value}")
    Double UsersumSYMeonkey(String uid);

    //查询用户本季度新增商机金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE QUARTER(b_date) = QUARTER(now())AND u_id=#{value}")
    Double UsersumJdMeonkey(String uid);

    //查询用户上季度新增商机金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE QUARTER(b_date) = QUARTER(DATE_SUB(NOW(),interval 1 QUARTER))AND u_id=#{value}")
    Double UsersumSJdMeonkey(String uid);

    //查询用户本年新增商机金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE YEAR(b_date)=YEAR(NOW())AND u_id=#{value}")
    Double UsersumNMeonkey(String uid);

    //查询用户上年新增商机金额
    @Select("SELECT SUM(b_monkey) FROM business WHERE YEAR(b_date)=YEAR(date_sub(NOW(),interval 1 YEAR)) AND u_id=#{value}")
    Double UsersumSNMeonkey(String uid);




}
