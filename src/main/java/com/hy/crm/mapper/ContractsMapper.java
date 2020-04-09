package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Contracts;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
public interface ContractsMapper extends BaseMapper<Contracts> {

    //    查询本周新增合同金额
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE YEARWEEK(DATE_FORMAT(ct_qddate,'%Y-%m-%d')) = YEARWEEK(NOW())")
    Double sumMeonkey();

    //    查询上周新增合同金额
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE YEARWEEK(DATE_FORMAT(ct_qddate,'%Y-%m-%d')) = YEARWEEK(NOW())-1")
    Double sumSMeonkey();


    //查询本月新增合同金额
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE DATE_FORMAT(ct_qddate,'%Y-%m') = DATE_FORMAT(CURDATE(),'%Y-%m')")
    Double sumYMeonkey();

    //查询上月新增合同金额
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE PERIOD_DIFF(DATE_FORMAT(NOW(),'%Y-%m'),DATE_FORMAT(ct_qddate,'%Y-%m')) = 1")
    Double sumSYMeonkey();

    //查询本季度新增合同金额
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE QUARTER(ct_qddate) = QUARTER(now())")
    Double sumJdMeonkey();

    //查询上季度新增合同金额
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE QUARTER(ct_qddate) = QUARTER(DATE_SUB(NOW(),interval 1 QUARTER))")
    Double sumSJdMeonkey();

    //查询本年新增金额合同
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE YEAR(ct_qddate)=YEAR(NOW())")
    Double sumNMeonkey();

    //查询上年新增合同金额
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE YEAR(ct_qddate)=YEAR(date_sub(NOW(),interval 1 YEAR))")
    Double sumSNMeonkey();

//已完成的合同

    //    查询本周完成合同金额
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE YEARWEEK(DATE_FORMAT(ct_qddate,'%Y-%m-%d')) = YEARWEEK(NOW())AND ct_status=5")
    Double fulfillsumMeonkey();

    //    查询上周完成合同金额
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE YEARWEEK(DATE_FORMAT(ct_qddate,'%Y-%m-%d')) = YEARWEEK(NOW())-1 AND ct_status=5")
    Double fulfillsumSMeonkey();


    //查询本月完成合同金额
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE DATE_FORMAT(ct_qddate,'%Y-%m') = DATE_FORMAT(CURDATE(),'%Y-%m')AND ct_status=5")
    Double fulfillsumYMeonkey();

    //查询上月完成合同金额
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE PERIOD_DIFF(DATE_FORMAT(NOW(),'%Y-%m'),DATE_FORMAT(ct_qddate,'%Y-%m')) = 1 AND ct_status=5")
    Double fulfillsumSYMeonkey();

    //查询本季度完成合同金额
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE QUARTER(ct_qddate) = QUARTER(now())AND ct_status=5")
    Double fulfillsumJdMeonkey();

    //查询上季度完成合同金额
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE QUARTER(ct_qddate) = QUARTER(DATE_SUB(NOW(),interval 1 QUARTER))AND ct_status=5")
    Double fulfillsumSJdMeonkey();

    //查询本年完成金额合同
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE YEAR(ct_qddate)=YEAR(NOW())AND ct_status=5")
    Double fulfillsumNMeonkey();

    //查询上年完成合同金额
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE YEAR(ct_qddate)=YEAR(date_sub(NOW(),interval 1 YEAR))AND ct_status=5")
    Double fulfillsumSNMeonkey();

    //////////////////////////////////////用户新增合同额
    //    查询用户本周新增合同金额
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE YEARWEEK(DATE_FORMAT(ct_qddate,'%Y-%m-%d')) = YEARWEEK(NOW())AND u_id=#{value}")
    Double UsersumMeonkey(String uid);

    //    查询用户上周新增合同金额
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE YEARWEEK(DATE_FORMAT(ct_qddate,'%Y-%m-%d')) = YEARWEEK(NOW())-1 AND u_id=#{value}")
    Double UsersumSMeonkey(String uid);

    //////////////////////////////////////用户成交合同额
    //    查询用户本周成交合同金额
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE YEARWEEK(DATE_FORMAT(ct_qddate,'%Y-%m-%d')) = YEARWEEK(NOW())AND ct_status=5 AND u_id=#{value}")
    Double UserfulfillsumMeonkey(String uid);

    //    查询用户上周成交合同金额
    @Select("SELECT SUM(ct_monkey) FROM contracts WHERE YEARWEEK(DATE_FORMAT(ct_qddate,'%Y-%m-%d')) = YEARWEEK(NOW())-1 AND ct_status=5 AND u_id=#{value}")
    Double UserfulfillsumSMeonkey(String uid);




}
