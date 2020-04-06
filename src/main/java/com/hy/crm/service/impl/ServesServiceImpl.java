package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.Serves;
import com.hy.crm.mapper.ServesMapper;
import com.hy.crm.service.IServesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

    @Override
    public IPage<Serves> pages(Integer page, Integer limit, Serves serves) {
        Page<Serves> servesPage = new Page<Serves>(page, limit);

        return servesMapper.queryAll(servesPage,serves);
    }
}
