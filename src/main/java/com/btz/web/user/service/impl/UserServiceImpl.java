package com.btz.web.user.service.impl;

import com.btz.web.system.account.service.AccountService;
import com.btz.web.user.dao.UserDao;
import com.btz.web.user.entity.UserEntity;
import com.btz.web.user.service.UserService;
import org.baron.framework.core.common.hibernate.DataGrid;
import org.baron.framework.core.ssh.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by User on 2017/5/19.
 */
@Service("userService")
@Transactional
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Autowired
     private UserDao userDao;

    public UserEntity checkUser(UserEntity userEntity) {
        return userDao.checkUser(userEntity.getUserId(),userEntity.getUserPwd());
    }

    public DataGrid<UserEntity> findPageList(DataGrid<UserEntity> userEntityDataGrid) {
        return userDao.findPageList(userEntityDataGrid);
    }
}
