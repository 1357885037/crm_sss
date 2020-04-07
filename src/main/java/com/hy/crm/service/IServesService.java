package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.Serves;

import java.util.List;

;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
public interface IServesService extends IService<Serves> {
    List<Serves> pages(Serves serves);
}
