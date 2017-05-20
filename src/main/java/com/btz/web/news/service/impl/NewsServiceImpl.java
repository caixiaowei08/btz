package com.btz.web.news.service.impl;

import com.btz.web.news.entity.NewsEntity;
import com.btz.web.news.service.NewsService;
import org.baron.framework.core.ssh.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by User on 2017/5/19.
 */
@Service("newsService")
@Transactional
public class NewsServiceImpl extends BaseServiceImpl implements NewsService {
    public NewsEntity doAdd(NewsEntity newsEntity) {
        return null;
    }

    public Integer doDel(NewsEntity newsEntity) {
        return null;
    }

    public Integer doUpdate(NewsEntity newsEntity) {
        return null;
    }
}
