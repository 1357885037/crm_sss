package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Users;
import com.hy.crm.mapper.LoginMapper;
import com.hy.crm.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mq
 * @since 2020-03-24
 */
@Transactional
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Users> implements ILoginService {

    @Autowired
    private LoginMapper loginMapper;


}
