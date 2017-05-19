package com.btz.web.user.dao;


import com.btz.web.user.entity.UserEntity;
import org.baron.framework.core.ssh.dao.BaseDao;

/**
 * Created by User on 2017/5/19.
 */
public interface UserDao extends BaseDao {

    public UserEntity checkUser(String userId, String userPwd);

}
