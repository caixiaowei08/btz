package com.btz.web.examination.service.impl;
import com.btz.web.examination.dao.CourseClassificationDao;
import com.btz.web.examination.dao.impl.CourseClassificationDaoImpl;
import com.btz.web.examination.entity.CourseClassificationEntity;
import com.btz.web.examination.service.CourseClassificationService;
import org.baron.framework.core.ssh.service.BaseService;
import org.baron.framework.core.ssh.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by User on 2017/4/5.
 */
@Service("courseClassificationService")
@Transactional
public class CourseClassificationServiceImpl extends BaseServiceImpl implements CourseClassificationService {

    @Autowired
    private CourseClassificationDao courseClassificationDao;

    public Integer save(CourseClassificationEntity courseClassificationEntity) {
        return (Integer)courseClassificationDao.save(courseClassificationEntity);
    }
}
