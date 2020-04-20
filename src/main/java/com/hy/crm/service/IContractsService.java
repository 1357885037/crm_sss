package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.Contracts;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
public interface IContractsService extends IService<Contracts> {

    //    查询本周新增合同金额
    Double sumMeonkey();

    //    查询上周新增合同金额
    Double sumSMeonkey();


    //查询本月新增合同金额
    Double sumYMeonkey();

    //查询上月新增合同金额
    Double sumSYMeonkey();

    //查询本季度新增合同金额
    Double sumJdMeonkey();

    //查询上季度新增合同金额
    Double sumSJdMeonkey();

    //查询本年新增金额合同
    Double sumNMeonkey();

    //查询上年新增合同金额
    Double sumSNMeonkey();



    //已完成的合同

    //    查询本周完成合同金额
    Double fulfillsumMeonkey();

    //    查询上周完成合同金额
    Double fulfillsumSMeonkey();

    //查询本月完成合同金额
    Double fulfillsumYMeonkey();

    //查询上月完成合同金额
    Double fulfillsumSYMeonkey();

    //查询本季度完成合同金额
    Double fulfillsumJdMeonkey();

    //查询上季度完成合同金额
    Double fulfillsumSJdMeonkey();

    //查询本年完成金额合同
    Double fulfillsumNMeonkey();

    //查询上年完成合同金额
    Double fulfillsumSNMeonkey();



    //////////////////////////////////////用户新增合同额
    //    查询用户本周新增合同金额
    Double UsersumMeonkey(String uid);

    //    查询用户上周新增合同金额
    Double UsersumSMeonkey(String uid);
    //查询本月新增合同金额
    Double UsersumYMeonkey(String uid);

    //查询上月新增合同金额
    Double UsersumSYMeonkey(String uid);

    //查询本季度新增合同金额
    Double UsersumJdMeonkey(String uid);

    //查询上季度新增合同金额
    Double UsersumSJdMeonkey(String uid);

    //查询本年新增金额合同
    Double UsersumNMeonkey(String uid);

    //查询上年新增合同金额
    Double UsersumSNMeonkey(String uid);



    //////////////////////////////////////用户成交合同额
    //////////////////////////////////////用户成交合同额
    //    查询用户本周成交合同金额
    Double UserfulfillsumMeonkey(String uid);

    //    查询用户上周成交合同金额
    Double UserfulfillsumSMeonkey(String uid);
    //查询本月完成合同金额
    Double UserfulfillsumYMeonkey(String uid);

    //查询上月完成合同金额
    Double UserfulfillsumSYMeonkey(String uid);

    //查询本季度完成合同金额
    Double UserfulfillsumJdMeonkey(String uid);

    //查询上季度完成合同金额
    Double UserfulfillsumSJdMeonkey(String uid);

    //查询本年完成金额合同
    Double UserfulfillsumNMeonkey(String uid);

    //查询上年完成合同金额
    Double UserfulfillsumSNMeonkey(String uid);



    //    上星期天
    double queryszr();
    //    上星期六
    double queryszl();
    //上星期五
    double queryszw();
    //上星期四
    double queryszf();
    //上星期三
    double queryszs();
    //上星期二
    double querysze();
    //上星期一
    double queryszy();


    //本周一
    double querybzy();
    //本周二
    double querybze();
    //            本周三
    double querybzs();
    //            本周四
    double querybzf();
    //            本周五
    double querybzw();
    //            本周六
    double querybzl();
    //            本周日
    double querybzr();

}
