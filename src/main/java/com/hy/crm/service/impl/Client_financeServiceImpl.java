package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Client_finance;
import com.hy.crm.mapper.Client_financeMapper;
import com.hy.crm.service.IClient_financeService;
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
public class Client_financeServiceImpl extends ServiceImpl<Client_financeMapper, Client_finance> implements IClient_financeService {

        @Autowired
        Client_financeMapper client_financeMapper;

        public Client_finance getbyc_id(String c_id){
            return client_financeMapper.getByid(c_id);
        }

        public Client_finance updateByC_id(Client_finance client_finance){
            return client_financeMapper.updateByc_id(client_finance);
        }




}
