package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.Serves;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
public interface ServesMapper extends BaseMapper<Serves> {

    //    分页联合查询
//    @Results({
//            @Result(property = "contracts.ct_id",column = "ct_id"),
//            @Result(property = "contracts.ct_name",column = "ct_name")
//    })
//    @SelectProvider(type = queryserve.class,method = "query")
//    @Select("select * from serves")
//    IPage<Serves> queryAll(@Param("Page") Page<Serves> page);


    @Select("select * from serves")
    IPage<Serves> queryAll(@Param("Pages") Page<Serves> page);

}
