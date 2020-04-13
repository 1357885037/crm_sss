package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Users;
import com.hy.crm.mapper.UsersMapper;
import com.hy.crm.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author TH
 * @since 2020-04-03
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Autowired
    UsersMapper usersMapper;
    public List<Users> asc_u_Realname(){
        return usersMapper.asc_u_Realname();
    }

}
