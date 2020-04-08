package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Clients;
import com.hy.crm.entity.Customer_management;
import org.apache.ibatis.annotations.Select;

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

    @Select("select c.c_id c_id,c.c_name c_name,(select count(*) from business b where b.c_id=c.c_id )  business_count,(select sum(b.b_monkey) from business b where b.c_id=c.c_id )  turnover,(select count(*) from contracts ct  where ct.b_id=(select b.b_id from business b where b.c_id=c.c_id)) contract_count,(select sum(ct_monkey) from contracts ct ,business b where ct.b_id=(select b.b_id from business b where b.c_id=c.c_id)) contract_amount,(select sum(re_monkey) from  remittance re where re.ct_id=(select ct.ct_id from contracts ct ,business b where ct.b_id=(select b.b_id from business b where b.c_id=c.c_id)  )) total_Return_amount ,(select count(*) from serves s where s.ct_id=(select ct.ct_id from contracts ct ,business b where ct.b_id=(select b.b_id from business b where b.c_id=c.c_id)   )) service_count ,(select avg(s_grade) from serves s  where s.ct_id=(select ct.ct_id from contracts ct ,business b where ct.b_id=(select b.b_id from business b where b.c_id=c.c_id) )) servic_Score   from  clients c , business b")
    public List<Customer_management> customer_management();

}
