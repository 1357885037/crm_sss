package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Withs;
import com.hy.crm.mapper.WithsMapper;
import com.hy.crm.service.IWithsService;
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
public class WithsServiceImpl extends ServiceImpl<WithsMapper, Withs> implements IWithsService {

    @Autowired
    private WithsMapper withsMapper;

    @Override
    public Double sumMeonkey() {
        return withsMapper.sumMeonkey();
    }

    @Override
    public Double sumSMeonkey() {
        return withsMapper.sumSMeonkey();
    }

    @Override
    public Double sumYMeonkey() {
        return withsMapper.sumYMeonkey();
    }

    @Override
    public Double sumSYMeonkey() {
        return withsMapper.sumSYMeonkey();
    }

    @Override
    public Double sumJdMeonkey() {
        return withsMapper.sumJdMeonkey();
    }

    @Override
    public Double sumSJdMeonkey() {
        return withsMapper.sumSJdMeonkey();
    }

    @Override
    public Double sumNMeonkey() {
        return withsMapper.sumNMeonkey();
    }

    @Override
    public Double sumSNMeonkey() {
        return withsMapper.sumSNMeonkey();
    }

    @Override
    public Double UsersumMeonkey(String uid) {
        return withsMapper.UsersumMeonkey(uid);
    }

    @Override
    public Double UsersumSMeonkey(String uid) {
        return withsMapper.UsersumSMeonkey(uid);
    }

    @Override
    public Double UsersumYMeonkey(String uid) {
        return withsMapper.UsersumYMeonkey(uid);
    }

    @Override
    public Double UsersumSYMeonkey(String uid) {
        return withsMapper.UsersumSYMeonkey( uid);
    }

    @Override
    public Double UsersumJdMeonkey(String uid) {
        return withsMapper.UsersumJdMeonkey( uid);
    }

    @Override
    public Double UsersumSJdMeonkey(String uid) {
        return withsMapper.UsersumSJdMeonkey( uid);
    }

    @Override
    public Double UsersumNMeonkey(String uid) {
        return withsMapper.UsersumNMeonkey( uid);
    }

    @Override
    public Double UsersumSNMeonkey(String uid) {
        return withsMapper.UsersumSNMeonkey( uid);
    }

    public List<Withs> query_ByB_id(Withs withs){
        return withsMapper.query_ByB_id(withs);
    }

}
