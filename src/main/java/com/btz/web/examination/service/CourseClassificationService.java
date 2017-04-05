package com.btz.web.examination.service;

import com.btz.web.examination.entity.CourseClassificationEntity;
import org.baron.framework.core.ssh.service.BaseService;

/**
 * Created by User on 2017/4/5.
 */
public interface CourseClassificationService extends BaseService {

    Integer save(CourseClassificationEntity courseClassificationEntity);


}
