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

}
