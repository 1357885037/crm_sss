package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.Clients;
import com.hy.crm.entity.Eachtes;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
public interface IClientsService extends IService<Clients> {

    /**
     * fdsf
     * @return
     */
    List<Eachtes> queryccc();
}
