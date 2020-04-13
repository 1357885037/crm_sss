package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author TH
 * @since 2020-04-03
 */
public interface UsersMapper extends BaseMapper<Users> {

    @Select("select * from users order by convert(u_Realname using gbk) collate gbk_chinese_ci asc;")
    public List<Users> asc_u_Realname();



}
