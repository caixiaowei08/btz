package org.baron.framework.core.common.hibernate;

import com.btz.web.user.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by User on 2017/5/20.
 */
public class HibernateHqlUtils {

    public static List getPageDataSql(Class clazz, DataGrid dataGrid, Session session, String params){
        String paramsList[] = null;
        if(StringUtils.hasText(params)){
            paramsList =  params.split(",");
        }
        StringBuffer dataHql = new StringBuffer();
        dataHql.append("from ");
        dataHql.append(clazz.getName()+" t ");
        if(StringUtils.hasText(dataGrid.getSearch())){
            if(paramsList != null){
                dataHql.append(" where 1=2 ");
                for(String param : paramsList){
                    dataHql.append(" or t."+param+" like :"+param);
                }
            }
        }
        if(StringUtils.hasText(dataGrid.getOrder())&&StringUtils.hasText(dataGrid.getSort())){
            dataHql.append(" order by "+dataGrid.getSort()+" "+dataGrid.getOrder());
        }
        Query query = session.createQuery(dataHql.toString());
        query.setFirstResult(dataGrid.getOffset());
        query.setMaxResults(dataGrid.getLimit());
        if(StringUtils.hasText(dataGrid.getSearch())){
            if(paramsList != null){
                for(String param : paramsList){
                    query.setParameter(param,"%"+dataGrid.getSearch()+"%");
                }
            }
        }
        return query.list();

    }

    public static Integer getPageCountSql(Class clazz,DataGrid dataGrid,Session session,String params){
        String paramsList[] = null;
        if(StringUtils.hasText(params)){
            paramsList =  params.split(",");
        }
        StringBuffer countHql = new StringBuffer();
        countHql.append("select count(*) from ");
        countHql.append(clazz.getName()+" t ");
        if(StringUtils.hasText(dataGrid.getSearch())){
            if(paramsList != null){
                countHql.append(" where 1=2 ");
                for(String param : paramsList){
                    countHql.append(" or t."+param+" like :"+param);
                }
            }
        }
        Query query = session.createQuery(countHql.toString());
        if(StringUtils.hasText(dataGrid.getSearch())){
            if(paramsList != null){
                for(String param : paramsList){
                    query.setParameter(param,"%"+dataGrid.getSearch()+"%");
                }
            }
        }
        Long countLong = (Long)query.list().get(0);
        return countLong.intValue();
    }

    public static DataGrid getDataGrid(Class clazz,DataGrid dataGrid,Session session,String params ){
        DataGrid t = new DataGrid();
        Integer count = HibernateHqlUtils.getPageCountSql(clazz,dataGrid,session,params);
        List data = HibernateHqlUtils.getPageDataSql(clazz,dataGrid,session,params);
        t.setRows(data);
        t.setTotal(count);
        return t;
    }



}
