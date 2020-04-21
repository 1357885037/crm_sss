package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.dynamic.Query_customer;
import com.hy.crm.entity.*;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
public interface ClientsMapper extends BaseMapper<Clients> {

    @Select("select * from clients order by convert(c_name using gbk) collate gbk_chinese_ci asc")
    public List<Clients> asc_c_name();
    @SelectProvider(type = Query_customer.class,method = "query")
    public List<Customer_management> customer_management(Clients clients);
    @SelectProvider(type = Query_customer.class,method = "query_Contract")
    public List<Customer_contract>  customer_contract(Business business);
    @Select("SELECT c_source AS name,COUNT(1) AS value FROM clients GROUP BY c_source ")
    List<Eachtes> querygroup();

}
