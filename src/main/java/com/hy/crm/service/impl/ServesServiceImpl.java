package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Serves;
import com.hy.crm.mapper.ServesMapper;
import com.hy.crm.service.IServesService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
@Service
public class ServesServiceImpl extends ServiceImpl<ServesMapper, Serves> implements IServesService {

    @Autowired
    private ServesMapper servesMapper;
    public IPage<Serves> pages(@Param("page") Integer page, @Param("limit")Integer limit) {
        Page<Serves> Pages = new Page<>(page, limit);
        return servesMapper.queryAll(Pages);
    }
}
