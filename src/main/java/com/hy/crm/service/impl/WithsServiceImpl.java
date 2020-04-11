package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Withs;
import com.hy.crm.mapper.WithsMapper;
import com.hy.crm.service.IWithsService;
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
public class WithsServiceImpl extends ServiceImpl<WithsMapper, Withs> implements IWithsService {

    @Autowired
    WithsMapper withsMapper;

    public List<Withs> query_ByB_id(Withs withs){
        return withsMapper.query_ByB_id(withs);
    }
}
