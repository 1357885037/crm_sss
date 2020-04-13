package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.Users;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author TH
 * @since 2020-04-03
 */
public interface IUsersService extends IService<Users> {
     void delusers(String value);

}
