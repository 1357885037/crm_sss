package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Business;
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
public interface BusinessMapper extends BaseMapper<Business> {

    @Select("select * from business order by convert(b_name using gbk) collate gbk_chinese_ci asc")
    public List<Business> asc_b_name();

}
