package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Clients;
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

}
