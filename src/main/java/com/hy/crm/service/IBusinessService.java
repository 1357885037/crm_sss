package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Eachtes;
import com.hy.crm.entity.Industry_Sources;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
public interface IBusinessService extends IService<Business> {



//    所有商机一共多少钱
String countMeonkey();


    String codemonkey2();

    String codemonkey3();

    String codemonkey4();

    String codemonkey5();

    //    本季度人
    Integer codeJdRen1();
    Integer codeJdRen2();
    Integer codeJdRen3();
    Integer codeJdRen4();
    Integer codeJdRen5();




    //    本季度
    String codeJdmonkey1();
    String codeJdmonkey2();
    String codeJdmonkey3();
    String codeJdmonkey4();
    String codeJdmonkey5();

    //上季度人
    Integer codeSJdRen1();
    Integer codeSJdRen2();
    Integer codeSJdRen3();
    Integer codeSJdRen4();
    Integer codeSJdRen5();




    //    上季度
    String codeSJdmonkey1();
    String codeSJdmonkey2();
    String codeSJdmonkey3();
    String codeSJdmonkey4();
    String codeSJdmonkey5();


    //年度人
    Integer codeNRen1();
    Integer codeNRen2();
    Integer codeNRen3();
    Integer codeNRen4();
    Integer codeNRen5();




    //年度
    String codeNmonkey1();
    String codeNmonkey2();
    String codeNmonkey3();
    String codeNmonkey4();
    String codeNmonkey5();

    //上年人
    Integer codeSNRen1();
    Integer codeSNRen2();
    Integer codeSNRen3();
    Integer codeSNRen4();
    Integer codeSNRen5();



    //上年
    String codeSNmonkey1();
    String codeSNmonkey2();
    String codeSNmonkey3();
    String codeSNmonkey4();
    String codeSNmonkey5();







    //    本周新增
    Double sumMeonkey();
//   上周新增
    Double sumSMeonkey();

    //查询本月新增商机金额
    Double sumYMeonkey();

    //查询上月新增商机金额
    Double sumSYMeonkey();

    //查询本季度新增商机金额
    Double sumJdMeonkey();

    //查询上季度新增商机金额
    Double sumSJdMeonkey();

    //查询本年新增商机金额
    Double sumNMeonkey();

    //查询上年新增商机金额
    Double sumSNMeonkey();
//////////////////////////////////用户商机
    //    查询用户本周新增商机金额
    Double UsersumMeonkey(String uid);

    //    查询用户上周新增商机金额
    Double UsersumSMeonkey(String uid);

    //查询用户本月新增商机金额
    Double UsersumYMeonkey(String uid);

    //查询用户上月新增商机金额
    Double UsersumSYMeonkey(String uid);

    //查询用户本季度新增商机金额
    Double UsersumJdMeonkey(String uid);

    //查询用户上季度新增商机金额
    Double UsersumSJdMeonkey(String uid);

    //查询用户本年新增商机金额
    Double UsersumNMeonkey(String uid);

    //查询用户上年新增商机金额
    Double UsersumSNMeonkey(String uid);


    //根据行业查商机
    Industry_Sources queryByindustry(String value);
//        按商机来源查询
    Industry_Sources querysjly(String value);

    //   根据客户类型进行差钱数的柱状图
    List<Eachtes> zquerybusiness();

    //   根据客户类型饼状图
    List<Eachtes> bshangjishu();

}
