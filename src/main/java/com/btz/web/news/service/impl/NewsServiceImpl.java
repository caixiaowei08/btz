package com.btz.web.news.service.impl;

import com.btz.web.news.dao.NewsDao;
import com.btz.web.news.entity.NewsEntity;
import com.btz.web.news.service.NewsService;
import org.baron.framework.core.ssh.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by User on 2017/5/19.
 */
@Service("newsService")
@Transactional
public class NewsServiceImpl extends BaseServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    public Integer doAdd(NewsEntity newsEntity) {
        return (Integer)newsDao.save(newsEntity);
    }

    public void doDel(NewsEntity newsEntity) {
        newsDao.deleteById(NewsEntity.class,newsEntity.getId());
    }

    public void doUpdate(NewsEntity newsEntity) {
        newsDao.update(newsEntity);
    }
}
