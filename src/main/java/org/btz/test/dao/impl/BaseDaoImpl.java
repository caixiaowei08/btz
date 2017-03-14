package org.btz.test.dao.impl;

import org.btz.test.dao.TestDao;
import org.btz.test.entity.AjaxEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 2017/3/14.
 */
@Repository("testDao")
public class BaseDaoImpl implements TestDao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    public void save(AjaxEntity ajaxEntity) {
        getSession().save(ajaxEntity);
    }
}
