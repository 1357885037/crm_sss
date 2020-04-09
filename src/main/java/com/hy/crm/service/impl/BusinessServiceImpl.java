package com.hy.crm.service.impl;

import com.hy.crm.entity.Business;
import com.hy.crm.mapper.BusinessMapper;
import com.hy.crm.service.IBusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public String countMeonkey() {
        return businessMapper.countMeonkey();
    }

    @Override
    public String codemonkey2() {
        return businessMapper.codemonkey2();
    }

    @Override
    public String codemonkey3() {
        return businessMapper.codemonkey3();
    }

    @Override
    public String codemonkey4() {
        return businessMapper.codemonkey4();
    }

    @Override
    public String codemonkey5() {
        return businessMapper.codemonkey5();
    }

    @Override
    public Double sumMeonkey() {
        return businessMapper.sumMeonkey();
    }

    @Override
    public Double sumSMeonkey() {
        return businessMapper.sumSMeonkey();
    }

    @Override
    public Double sumYMeonkey() {
        return businessMapper.sumYMeonkey();
    }

    @Override
    public Double sumSYMeonkey() {
        return businessMapper.sumSYMeonkey();
    }

    @Override
    public Double sumJdMeonkey() {
        return businessMapper.sumJdMeonkey();
    }

    @Override
    public Double sumSJdMeonkey() {
        return businessMapper.sumSJdMeonkey();
    }

    @Override
    public Double sumNMeonkey() {
        return businessMapper.sumNMeonkey();
    }

    @Override
    public Double sumSNMeonkey() {
        return businessMapper.sumSNMeonkey();
    }

    @Override
    public Double UsersumMeonkey(String uid) {
        return businessMapper.UsersumMeonkey(uid);
    }

    @Override
    public Double UsersumSMeonkey(String uid) {
        return businessMapper.UsersumSMeonkey(uid);
    }

    @Override
    public Double UsersumYMeonkey(String uid) {
        return businessMapper.UsersumYMeonkey(uid);
    }

    @Override
    public Double UsersumSYMeonkey(String uid) {
        return businessMapper.UsersumSYMeonkey(uid);
    }

    @Override
    public Double UsersumJdMeonkey(String uid) {
        return businessMapper.UsersumJdMeonkey(uid);
    }

    @Override
    public Double UsersumSJdMeonkey(String uid) {
        return businessMapper.UsersumSJdMeonkey(uid);
    }

    @Override
    public Double UsersumNMeonkey(String uid) {
        return businessMapper.UsersumNMeonkey(uid);
    }

    @Override
    public Double UsersumSNMeonkey(String uid) {
        return businessMapper.UsersumSNMeonkey(uid);
    }

}
