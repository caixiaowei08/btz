package com.btz.web.news.service;

import com.btz.web.news.entity.NewsEntity;
import org.baron.framework.core.ssh.service.BaseService;

/**
 * Created by User on 2017/5/19.
 */
public interface NewsService extends BaseService {

    public Integer doAdd(NewsEntity newsEntity);

    public void doDel(NewsEntity newsEntity);

    public void doUpdate(NewsEntity newsEntity);



}
