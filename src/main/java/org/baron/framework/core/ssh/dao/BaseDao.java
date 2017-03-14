package org.baron.framework.core.ssh.dao;

import java.io.Serializable;

/**
 * Created by User on 2017/3/14.
 */
public interface BaseDao {

    public <T> Serializable save(T entity);

    public <T> void deleteById(Class entity,Serializable id);

    public <T> void update(T entity);

    public <T> T get(Class<T> entityName, Serializable id);

}
