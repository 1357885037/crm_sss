package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Clients;
import com.hy.crm.entity.Customer_contract;
import com.hy.crm.entity.Customer_management;
import com.hy.crm.mapper.ClientsMapper;
import com.hy.crm.service.IClientsService;
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
public class ClientsServiceImpl extends ServiceImpl<ClientsMapper, Clients> implements IClientsService {

        @Autowired
        private ClientsMapper clientsMapper;

        //查询所有的客户 并按名字首字母排序
        public List<Clients> asc_c_name(){
            return clientsMapper.asc_c_name();
        }
        public List<Customer_management> customer_managements(Clients clients){
            return clientsMapper.customer_management(clients);
        }

    public List<Customer_contract>  customer_contract(Business business){
            return clientsMapper.customer_contract(business);
    };

}
