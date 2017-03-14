package org.btz.test.service.impl;

import org.btz.test.dao.TestDao;
import org.btz.test.entity.AjaxEntity;
import org.btz.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by User on 2017/3/13.
 */
@Service("testService")
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    public void test() {
        AjaxEntity ajaxEntity = new AjaxEntity();
        ajaxEntity.setName("应云辉");
        ajaxEntity.setAge(100);
        testDao.save(ajaxEntity);
    }
}
