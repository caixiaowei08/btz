package com.btz.web.user.dao;


import com.btz.web.user.entity.UserEntity;
import org.baron.framework.core.common.hibernate.DataGrid;
import org.baron.framework.core.ssh.dao.BaseDao;

import java.util.List;

/**
 * Created by User on 2017/5/19.
 */
public interface UserDao extends BaseDao {

    public UserEntity checkUser(String userId, String userPwd);

    public DataGrid findPageList(DataGrid<UserEntity> userEntityDataGrid);


}
