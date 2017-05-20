package org.baron.framework.core.ssh.dao.impl;

import org.baron.framework.core.common.hibernate.DataGrid;
import org.baron.framework.core.ssh.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by User on 2017/3/14.
 */
@SuppressWarnings("hiding")
public abstract class BaseDaoImpl<T>implements BaseDao{
    private static Logger logger = LogManager.getLogger(BaseDaoImpl.class.getName());
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

   public Session getSession(){
       return sessionFactory.getCurrentSession();
   }
    /**
     * 单条数据的增删改查
     */
    public <T> Serializable save(T entity) {
        try {
            Serializable id = getSession().save(entity);
            if (logger.isDebugEnabled()) {
                logger.debug("保存实体成功," + entity.getClass().getName());
            }
            return id;
        } catch (RuntimeException e) {
            logger.error("保存实体异常", e);
            throw e;
        }
    }

    public <T> void deleteById(Class entityName, Serializable id) {
        delete(get(entityName, id));
    }

    /**
     * 根据传入的实体删除对象
     */
    public <T> void delete(T entity) {
        try {
            getSession().delete(entity);
            if (logger.isDebugEnabled()) {
                logger.debug("删除成功," + entity.getClass().getName());
            }
        } catch (RuntimeException e) {
            logger.error("删除异常", e);
            throw e;
        }
    }

    public <T> void update(T pojo) {
        getSession().update(pojo);
    }
    /**
     * 根据Id获取对象。
     */
    public <T> T get(Class<T> entityClass, final Serializable id) {
        return (T) getSession().get(entityClass, id);
    }
}
