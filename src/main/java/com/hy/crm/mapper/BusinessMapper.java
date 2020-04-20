package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Eachtes;
import com.hy.crm.entity.Industry_Sources;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

//    本季度人
    @Select("SELECT count(*) FROM business WHERE QUARTER(b_date) = QUARTER(now()) and b_code=1")
    Integer codeJdRen1();
    @Select("SELECT count(*) FROM business WHERE QUARTER(b_date) = QUARTER(now()) and b_code=2")
    Integer codeJdRen2();
    @Select("SELECT count(*) FROM business WHERE QUARTER(b_date) = QUARTER(now()) and b_code=3")
    Integer codeJdRen3();
    @Select("SELECT count(*) FROM business WHERE QUARTER(b_date) = QUARTER(now()) and b_code=4")
    Integer codeJdRen4();
    @Select("SELECT count(*) FROM business WHERE QUARTER(b_date) = QUARTER(now()) and b_code=5")
    Integer codeJdRen5();


//    本季度钱
    @Select("SELECT SUM(b_monkey) FROM business WHERE QUARTER(b_date) = QUARTER(now()) and b_code=1")
    String codeJdmonkey1();
    @Select("SELECT SUM(b_monkey) FROM business WHERE QUARTER(b_date) = QUARTER(now()) and b_code=2")
    String codeJdmonkey2();
    @Select("SELECT SUM(b_monkey) FROM business WHERE QUARTER(b_date) = QUARTER(now()) and b_code=3")
    String codeJdmonkey3();
    @Select("SELECT SUM(b_monkey) FROM business WHERE QUARTER(b_date) = QUARTER(now()) and b_code=4")
    String codeJdmonkey4();
    @Select("SELECT SUM(b_monkey) FROM business WHERE QUARTER(b_date) = QUARTER(now()) and b_code=5")
    String codeJdmonkey5();

    //上季度人
    @Select("SELECT count(0) FROM business WHERE QUARTER(b_date) = QUARTER(DATE_SUB(NOW(),interval 1 QUARTER)) and b_code=1")
    Integer codeSJdRen1();
    @Select("SELECT count(0) FROM business WHERE QUARTER(b_date) = QUARTER(DATE_SUB(NOW(),interval 1 QUARTER)) and b_code=2")
    Integer codeSJdRen2();
    @Select("SELECT count(0) FROM business WHERE QUARTER(b_date) = QUARTER(DATE_SUB(NOW(),interval 1 QUARTER)) and b_code=3")
    Integer codeSJdRen3();
    @Select("SELECT count(0) FROM business WHERE QUARTER(b_date) = QUARTER(DATE_SUB(NOW(),interval 1 QUARTER)) and b_code=4")
    Integer codeSJdRen4();
    @Select("SELECT count(0) FROM business WHERE QUARTER(b_date) = QUARTER(DATE_SUB(NOW(),interval 1 QUARTER)) and b_code=5")
    Integer codeSJdRen5();



//    上季度
@Select("SELECT SUM(b_monkey) FROM business WHERE QUARTER(b_date) = QUARTER(DATE_SUB(NOW(),interval 1 QUARTER)) and b_code=1")
String codeSJdmonkey1();
@Select("SELECT SUM(b_monkey) FROM business WHERE QUARTER(b_date) = QUARTER(DATE_SUB(NOW(),interval 1 QUARTER)) and b_code=2")
String codeSJdmonkey2();
@Select("SELECT SUM(b_monkey) FROM business WHERE QUARTER(b_date) = QUARTER(DATE_SUB(NOW(),interval 1 QUARTER)) and b_code=3")
String codeSJdmonkey3();
@Select("SELECT SUM(b_monkey) FROM business WHERE QUARTER(b_date) = QUARTER(DATE_SUB(NOW(),interval 1 QUARTER)) and b_code=4")
String codeSJdmonkey4();
@Select("SELECT SUM(b_monkey) FROM business WHERE QUARTER(b_date) = QUARTER(DATE_SUB(NOW(),interval 1 QUARTER)) and b_code=5")
String codeSJdmonkey5();

//年度人
@Select("SELECT count(*) FROM business WHERE YEAR(b_date)=YEAR(NOW()) and b_code=1")
Integer codeNRen1();
@Select("SELECT count(*) FROM business WHERE YEAR(b_date)=YEAR(NOW()) and b_code=2")
Integer codeNRen2();
@Select("SELECT count(*) FROM business WHERE YEAR(b_date)=YEAR(NOW()) and b_code=3")
Integer codeNRen3();
@Select("SELECT count(*) FROM business WHERE YEAR(b_date)=YEAR(NOW()) and b_code=4")
Integer codeNRen4();
@Select("SELECT count(*) FROM business WHERE YEAR(b_date)=YEAR(NOW()) and b_code=5")
Integer codeNRen5();



//年度
@Select("SELECT SUM(b_monkey) FROM business WHERE YEAR(b_date)=YEAR(NOW()) and b_code=1")
String codeNmonkey1();
@Select("SELECT SUM(b_monkey) FROM business WHERE YEAR(b_date)=YEAR(NOW()) and b_code=2")
String codeNmonkey2();
@Select("SELECT SUM(b_monkey) FROM business WHERE YEAR(b_date)=YEAR(NOW()) and b_code=3")
String codeNmonkey3();
@Select("SELECT SUM(b_monkey) FROM business WHERE YEAR(b_date)=YEAR(NOW()) and b_code=4")
String codeNmonkey4();
@Select("SELECT SUM(b_monkey) FROM business WHERE YEAR(b_date)=YEAR(NOW()) and b_code=5")
String codeNmonkey5();

    //上年人
    @Select("SELECT count(*) FROM business WHERE YEAR(b_date)=YEAR(date_sub(NOW(),interval 1 YEAR)) and b_code=1")
    Integer codeSNRen1();
    @Select("SELECT count(*) FROM business WHERE YEAR(b_date)=YEAR(date_sub(NOW(),interval 1 YEAR)) and b_code=2")
    Integer codeSNRen2();
    @Select("SELECT count(*) FROM business WHERE YEAR(b_date)=YEAR(date_sub(NOW(),interval 1 YEAR)) and b_code=3")
    Integer codeSNRen3();
    @Select("SELECT count(*) FROM business WHERE YEAR(b_date)=YEAR(date_sub(NOW(),interval 1 YEAR)) and b_code=4")
    Integer codeSNRen4();
    @Select("SELECT count(*) FROM business WHERE YEAR(b_date)=YEAR(date_sub(NOW(),interval 1 YEAR)) and b_code=5")
    Integer codeSNRen5();


//上年
@Select("SELECT SUM(b_monkey) FROM business WHERE YEAR(b_date)=YEAR(date_sub(NOW(),interval 1 YEAR)) and b_code=1")
String codeSNmonkey1();
@Select("SELECT SUM(b_monkey) FROM business WHERE YEAR(b_date)=YEAR(date_sub(NOW(),interval 1 YEAR)) and b_code=2")
String codeSNmonkey2();
@Select("SELECT SUM(b_monkey) FROM business WHERE YEAR(b_date)=YEAR(date_sub(NOW(),interval 1 YEAR)) and b_code=3")
String codeSNmonkey3();
@Select("SELECT SUM(b_monkey) FROM business WHERE YEAR(b_date)=YEAR(date_sub(NOW(),interval 1 YEAR)) and b_code=4")
String codeSNmonkey4();
@Select("SELECT SUM(b_monkey) FROM business WHERE YEAR(b_date)=YEAR(date_sub(NOW(),interval 1 YEAR)) and b_code=5")
String codeSNmonkey5();






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

//根据行业查商机
@Select("SELECT COUNT(0) AS COUNT,SUM(b_monkey) AS SUM FROM business WHERE c_id IN(SELECT c_id FROM clients WHERE c_industry=#{value})")
    Industry_Sources queryByindustry(String value);

//根据商机来源查询
 @Select("SELECT COUNT(0) AS COUNT,SUM(b_monkey) AS SUM FROM business WHERE b_source=#{value}")
    Industry_Sources querysjly(String value);


    @Select("select * from business order by convert(b_name using gbk) collate gbk_chinese_ci asc")
    public List<Business> asc_b_name();

//   根据客户类型进行差钱数的柱状图
    @Select("SELECT SUM(b_monkey) AS 'value',b_source AS 'name' FROM business GROUP BY b_source")
    List<Eachtes> zquerybusiness();

    //   根据客户类型饼状图
    @Select("SELECT COUNT(1) AS  'value',b_source AS 'name' FROM business GROUP BY b_source")
    List<Eachtes> bshangjishu();

}
