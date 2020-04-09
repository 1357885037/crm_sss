package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.Business;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
public interface IBusinessService extends IService<Business> {

    Double sumMeonkey();
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





}
