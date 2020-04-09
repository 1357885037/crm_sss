package com.hy.crm.service.impl;

import com.hy.crm.entity.Contracts;
import com.hy.crm.mapper.ContractsMapper;
import com.hy.crm.service.IContractsService;
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
public class ContractsServiceImpl extends ServiceImpl<ContractsMapper, Contracts> implements IContractsService {


    @Autowired
    private  ContractsMapper contractsMapper;

    @Override
    public Double sumMeonkey() {
        return contractsMapper.sumMeonkey();
    }

    @Override
    public Double sumSMeonkey() {
        return contractsMapper.sumSMeonkey();
    }

    @Override
    public Double sumYMeonkey() {
        return contractsMapper.sumYMeonkey();
    }

    @Override
    public Double sumSYMeonkey() {
        return contractsMapper.sumSYMeonkey();
    }

    @Override
    public Double sumJdMeonkey() {
        return contractsMapper.sumJdMeonkey();
    }

    @Override
    public Double sumSJdMeonkey() {
        return contractsMapper.sumSJdMeonkey();
    }

    @Override
    public Double sumNMeonkey() {
        return contractsMapper.sumNMeonkey();
    }

    @Override
    public Double sumSNMeonkey() {
        return contractsMapper.sumSNMeonkey();
    }

//    已完成的合同

    @Override
    public Double fulfillsumMeonkey() {
        return contractsMapper.fulfillsumMeonkey();
    }

    @Override
    public Double fulfillsumSMeonkey() {
        return contractsMapper.fulfillsumSMeonkey();
    }

    @Override
    public Double fulfillsumYMeonkey() {
        return contractsMapper.fulfillsumYMeonkey();
    }

    @Override
    public Double fulfillsumSYMeonkey() {
        return contractsMapper.fulfillsumSYMeonkey();
    }

    @Override
    public Double fulfillsumJdMeonkey() {
        return contractsMapper.fulfillsumJdMeonkey();
    }

    @Override
    public Double fulfillsumSJdMeonkey() {
        return contractsMapper.fulfillsumSJdMeonkey();
    }

    @Override
    public Double fulfillsumNMeonkey() {
        return contractsMapper.fulfillsumNMeonkey();
    }

    @Override
    public Double fulfillsumSNMeonkey() {
        return contractsMapper.fulfillsumSNMeonkey();
    }

    @Override
    public Double UsersumMeonkey(String uid) {
        return contractsMapper.UsersumMeonkey(uid);
    }

    @Override
    public Double UsersumSMeonkey(String uid) {
        return contractsMapper.UsersumSMeonkey(uid);
    }

    @Override
    public Double UserfulfillsumMeonkey(String uid) {
        return contractsMapper.UserfulfillsumMeonkey(uid);
    }

    @Override
    public Double UserfulfillsumSMeonkey(String uid) {
        return contractsMapper.UserfulfillsumSMeonkey(uid);
    }

}
