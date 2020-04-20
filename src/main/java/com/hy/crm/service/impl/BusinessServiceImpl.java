package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Eachtes;
import com.hy.crm.entity.Industry_Sources;
import com.hy.crm.mapper.BusinessMapper;
import com.hy.crm.service.IBusinessService;
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
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {

    @Autowired
    BusinessMapper businessMapper;
    public List<Business> asc_b_name(){
        return businessMapper.asc_b_name();
    }


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
    public Integer codeJdRen1() {
        return businessMapper.codeJdRen1();
    }

    @Override
    public Integer codeJdRen2() {
        return businessMapper.codeJdRen2();
    }

    @Override
    public Integer codeJdRen3() {
        return businessMapper.codeJdRen3();
    }

    @Override
    public Integer codeJdRen4() {
        return businessMapper.codeJdRen4();
    }

    @Override
    public Integer codeJdRen5() {
        return businessMapper.codeJdRen5();
    }

    @Override
    public String codeJdmonkey1() {
        return businessMapper.codeJdmonkey1();
    }

    @Override
    public String codeJdmonkey2() {
        return businessMapper.codeJdmonkey2();
    }

    @Override
    public String codeJdmonkey3() {
        return businessMapper.codeJdmonkey3();
    }

    @Override
    public String codeJdmonkey4() {
        return businessMapper.codeJdmonkey4();
    }

    @Override
    public String codeJdmonkey5() {
        return businessMapper.codeJdmonkey5();
    }

    @Override
    public Integer codeSJdRen1() {
        return businessMapper.codeSJdRen1();
    }

    @Override
    public Integer codeSJdRen2() {
        return businessMapper.codeSJdRen2();
    }

    @Override
    public Integer codeSJdRen3() {
        return businessMapper.codeSJdRen3();
    }

    @Override
    public Integer codeSJdRen4() {
        return businessMapper.codeSJdRen4();
    }

    @Override
    public Integer codeSJdRen5() {
        return businessMapper.codeSJdRen5();
    }

    @Override
    public String codeSJdmonkey1() {
        return businessMapper.codeSJdmonkey1();
    }

    @Override
    public String codeSJdmonkey2() {
        return businessMapper.codeSJdmonkey2();
    }

    @Override
    public String codeSJdmonkey3() {
        return businessMapper.codeSJdmonkey3();
    }

    @Override
    public String codeSJdmonkey4() {
        return businessMapper.codeSJdmonkey4();
    }

    @Override
    public String codeSJdmonkey5() {
        return businessMapper.codeSJdmonkey5();
    }

    @Override
    public Integer codeNRen1() {
        return businessMapper.codeNRen1();
    }

    @Override
    public Integer codeNRen2() {
        return businessMapper.codeNRen2();
    }

    @Override
    public Integer codeNRen3() {
        return businessMapper.codeNRen3();
    }

    @Override
    public Integer codeNRen4() {
        return businessMapper.codeNRen4();
    }

    @Override
    public Integer codeNRen5() {
        return businessMapper.codeNRen5();
    }

    @Override
    public String codeNmonkey1() {
        return businessMapper.codeNmonkey1();
    }

    @Override
    public String codeNmonkey2() {
        return businessMapper.codeNmonkey2();
    }

    @Override
    public String codeNmonkey3() {
        return businessMapper.codeNmonkey3();
    }

    @Override
    public String codeNmonkey4() {
        return businessMapper.codeNmonkey4();
    }

    @Override
    public String codeNmonkey5() {
        return businessMapper.codeNmonkey5();
    }

    @Override
    public Integer codeSNRen1() {
        return businessMapper.codeSNRen1();
    }

    @Override
    public Integer codeSNRen2() {
        return businessMapper.codeSNRen2();
    }

    @Override
    public Integer codeSNRen3() {
        return businessMapper.codeSNRen3();
    }

    @Override
    public Integer codeSNRen4() {
        return businessMapper.codeSNRen4();
    }

    @Override
    public Integer codeSNRen5() {
        return businessMapper.codeSNRen5();
    }

    @Override
    public String codeSNmonkey1() {
        return businessMapper.codeSNmonkey1();
    }

    @Override
    public String codeSNmonkey2() {
        return businessMapper.codeSNmonkey2();
    }

    @Override
    public String codeSNmonkey3() {
        return businessMapper.codeSNmonkey3();
    }

    @Override
    public String codeSNmonkey4() {
        return businessMapper.codeSNmonkey4();
    }

    @Override
    public String codeSNmonkey5() {
        return businessMapper.codeSNmonkey5();
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

    @Override
    public Industry_Sources queryByindustry(String value) {
        return businessMapper.queryByindustry(value);
    }

    @Override
    public Industry_Sources querysjly(String value) {
        return businessMapper.querysjly(value);
    }

    @Override
    public List<Eachtes> zquerybusiness() {
        return businessMapper.zquerybusiness();
    }

    @Override
    public List<Eachtes> bshangjishu() {
        return businessMapper.bshangjishu();
    }

    @Override
    public List<Eachtes> bkehushangjigeshu() {
        return businessMapper.bkehushangjigeshu();
    }

    @Override
    public List<Eachtes> bkehumonkey() {
        return businessMapper.bkehumonkey();
    }



}
