package com.btz.web.user.dao.impl;

import com.btz.web.system.account.entity.AccountEntity;
import com.btz.web.user.dao.UserDao;
import com.btz.web.user.entity.UserEntity;
import org.baron.framework.core.common.hibernate.DataGrid;
import org.baron.framework.core.common.hibernate.HibernateHqlUtils;
import org.baron.framework.core.ssh.dao.impl.BaseDaoImpl;
import org.baron.framework.utils.PasswordUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by User on 2017/5/19.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    public UserEntity checkUser(String userId, String userPwd) {
        String HQL= new String("from UserEntity u where u.userId = :userId and u.userPwd=:userPwd");
        Session session = getSession();
        Query query = session.createQuery(HQL);
        query.setParameter("userId", userId);
        query.setParameter("userPwd", PasswordUtil.getMD5Encryp(userPwd));
        List<UserEntity> userList = query.list();
        if(CollectionUtils.isEmpty(userList)){
            return null;
        }
        return userList.get(0);
    }

    public DataGrid findPageList(DataGrid<UserEntity> userEntityDataGrid) {
        return HibernateHqlUtils.getDataGrid(UserEntity.class,userEntityDataGrid,getSession(),"userId,userName");
    }
}
