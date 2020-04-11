package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.dynamic.Query_Withs;
import com.hy.crm.entity.Withs;
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
public interface WithsMapper extends BaseMapper<Withs> {

    @SelectProvider(type = Query_Withs.class,method = "query_ByB_id")
    public List<Withs> query_ByB_id(Withs withs);
}
