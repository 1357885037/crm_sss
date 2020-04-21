package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.Withs;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
public interface IWithsService extends IService<Withs> {

    //    查询本周新增跟单预计金额
    Double sumMeonkey();
    //    查询上周新增跟单预计金额
    Double sumSMeonkey();
    //查询本月新增跟单预计金额
    Double sumYMeonkey();
    //查询上月新增跟单预计金额
    Double sumSYMeonkey();
    //查询本季度新增跟单预计金额
    Double sumJdMeonkey();
    //查询上季度新增跟单预计金额
    Double sumSJdMeonkey();
    //查询本年新增跟单预计金额
    Double sumNMeonkey();
    //查询上年新增跟单预计金额
    Double sumSNMeonkey();

//////////////////////////////////////用户跟单预计成交额
    //    查询用户本周新增跟单金额
    Double UsersumMeonkey(String uid);
    //    查询用户上周新增跟单金额
    Double UsersumSMeonkey(String uid);
    //查询本月新增跟单预计金额
    Double UsersumYMeonkey(String uid);
    //查询上月新增跟单预计金额
    Double UsersumSYMeonkey(String uid);
    //查询本季度新增跟单预计金额
    Double UsersumJdMeonkey(String uid);
    //查询上季度新增跟单预计金额
    Double UsersumSJdMeonkey(String uid);
    //查询本年新增跟单预计金额
    Double UsersumNMeonkey(String uid);
    //查询上年新增跟单预计金额
    Double UsersumSNMeonkey(String uid);

}
