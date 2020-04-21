package com.hy.crm.mapper;

import com.hy.crm.entity.Client_finance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
public interface Client_financeMapper extends BaseMapper<Client_finance> {

    @Select("select * from client_finance c where c.c_id=#{value}")
    public Client_finance getByid(String c_id);
    @Select("update  client_finance  set cf_number=#{cf_number},cf_name=#{cf_number},cf_bank=#{cf_bank},cf_site=#{cf_site},cf_duty=#{cf_duty},cf_phone=#{cf_phone} where c_id=#{c_id} ")
    public Client_finance updateByc_id(Client_finance client_finance);
}
