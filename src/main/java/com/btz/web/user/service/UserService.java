package com.btz.web.user.service;

import com.btz.web.user.entity.UserEntity;
import org.baron.framework.core.ssh.service.BaseService;

/**
 * Created by User on 2017/5/19.
 */
public interface UserService extends BaseService {
    public UserEntity checkUser(UserEntity userEntity);
}
