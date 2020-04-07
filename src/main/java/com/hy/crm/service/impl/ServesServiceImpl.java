package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Serves;
import com.hy.crm.mapper.ServesMapper;
import com.hy.crm.service.IServesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Serves> pages( Serves serves) {
        return servesMapper.queryAll(serves);
    }
}
