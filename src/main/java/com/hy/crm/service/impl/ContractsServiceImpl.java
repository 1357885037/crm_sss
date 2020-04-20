package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Clients;
import com.hy.crm.entity.Contracts;
import com.hy.crm.mapper.ContractsMapper;
import com.hy.crm.service.IContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public List<Contracts> queryall(Contracts contracts, Clients clients){
        return contractsMapper.queryall(contracts,clients);
    }


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
    public Double UsersumYMeonkey(String uid) {
        return contractsMapper.UsersumYMeonkey(uid);
    }

    @Override
    public Double UsersumSYMeonkey(String uid) {
        return contractsMapper.UsersumSYMeonkey(uid);
    }

    @Override
    public Double UsersumJdMeonkey(String uid) {
        return contractsMapper.UsersumJdMeonkey(uid);
    }

    @Override
    public Double UsersumSJdMeonkey(String uid) {
        return contractsMapper.UsersumSJdMeonkey(uid);
    }

    @Override
    public Double UsersumNMeonkey(String uid) {
        return contractsMapper.UsersumNMeonkey(uid);
    }

    @Override
    public Double UsersumSNMeonkey(String uid) {
        return contractsMapper.UsersumSNMeonkey(uid);
    }

    @Override
    public Double UserfulfillsumMeonkey(String uid) {
        return contractsMapper.UserfulfillsumMeonkey(uid);
    }

    @Override
    public Double UserfulfillsumSMeonkey(String uid) {
        return contractsMapper.UserfulfillsumSMeonkey(uid);
    }

    @Override
    public Double UserfulfillsumYMeonkey(String uid) {
        return contractsMapper.UserfulfillsumYMeonkey(uid);
    }

    @Override
    public Double UserfulfillsumSYMeonkey(String uid) {
        return contractsMapper.UserfulfillsumSYMeonkey(uid);
    }

    @Override
    public Double UserfulfillsumJdMeonkey(String uid) {
        return contractsMapper.UserfulfillsumJdMeonkey(uid);
    }

    @Override
    public Double UserfulfillsumSJdMeonkey(String uid) {
        return contractsMapper.UserfulfillsumSJdMeonkey(uid);
    }

    @Override
    public Double UserfulfillsumNMeonkey(String uid) {
        return contractsMapper.UserfulfillsumNMeonkey(uid);
    }

    @Override
    public Double UserfulfillsumSNMeonkey(String uid) {
        return contractsMapper.UserfulfillsumSNMeonkey(uid);
    }

    @Override
    public double queryszr() {

        if(contractsMapper.queryszr()==null) {
            return 0.0;
        }
        return Double.valueOf(contractsMapper.queryszr());
    }

    @Override
    public double queryszl() {
        if(contractsMapper.queryszl()==null) {
            return 0.0;
        }
        return Double.valueOf(contractsMapper.queryszl());
    }

    @Override
    public double queryszw() {
        if(contractsMapper.queryszw()==null) {
            return 0.0;
        }
        return Double.valueOf(contractsMapper.queryszw());
}

    @Override
    public double queryszf() {
        if(contractsMapper.queryszf()==null) {
            return 0.0;
        }
        return Double.valueOf(contractsMapper.queryszf());
    }

    @Override
    public double queryszs() {
        if(contractsMapper.queryszs()==null) {
            return 0.0;
        }
        return Double.valueOf(contractsMapper.queryszs());
    }

    @Override
    public double querysze() {
        if(contractsMapper.querysze()==null) {
            return 0.0;
        }
        return Double.valueOf(contractsMapper.querysze());
    }

    @Override
    public double queryszy() {
        if(contractsMapper.queryszy()==null) {
            return 0.0;
        }
        return Double.valueOf(contractsMapper.queryszy());
    }

    @Override
    public double querybzy() {

        if(contractsMapper.querybzy()==null){
            return 0.0;
        }
            return Double.valueOf(contractsMapper.querybzy());

    }

    @Override
    public double querybze() {
        if(contractsMapper.querybze()==null){
            return 0.0;
        }
            return Double.valueOf(contractsMapper.querybze());
}

    @Override
    public double querybzs() {
        if(contractsMapper.querybzs()==null){
            return 0.0;
        }
            return Double.valueOf(contractsMapper.querybzs());
    }

    @Override
    public double querybzf() {
        if(contractsMapper.querybzf()==null) {
            return 0.0;
        }
        return Double.valueOf(contractsMapper.querybzf());
    }

    @Override
    public double querybzw() {
        if(contractsMapper.querybzw()==null) {
            return 0.0;
        }
        return Double.valueOf(contractsMapper.querybzw());
    }

    @Override
    public double querybzl() {
        if(contractsMapper.querybzl()==null) {
            return 0.0;
        }
        return Double.valueOf(contractsMapper.querybzl());
    }

    @Override
    public double querybzr() {
        if(contractsMapper.querybzr()==null) {
            return 0.0;
        }
        return Double.valueOf(contractsMapper.querybzr());
    }

}
