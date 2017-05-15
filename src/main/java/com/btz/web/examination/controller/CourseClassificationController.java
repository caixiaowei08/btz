package com.btz.web.examination.controller;

import com.btz.web.examination.entity.CourseClassificationEntity;
import com.btz.web.examination.service.CourseClassificationService;
import org.baron.framework.component.vo.AjaxJson;
import org.baron.framework.component.vo.AjaxRequestJQueryDt;
import org.baron.framework.component.vo.AjaxResponseJQueryDt;
import org.baron.framework.core.ssh.controller.BaseController;
import org.btz.test.entity.AjaxEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 2017/4/5.
 */
@Controller
@RequestMapping("courseClassificationController")
public class CourseClassificationController extends BaseController{

    @Autowired
    private CourseClassificationService courseClassificationService;

    @RequestMapping(params = "datagrid")
    @ResponseBody
    public AjaxResponseJQueryDt test(AjaxRequestJQueryDt ajaxRequestJQueryDt, HttpServletRequest request, HttpServletResponse response) {

        AjaxResponseJQueryDt ajaxResponseJQueryDt = new AjaxResponseJQueryDt();
        List<CourseClassificationEntity> courseClassificationEntitiesList = new ArrayList<CourseClassificationEntity>();
        for (int i = 0; i < 10; i++) {
            CourseClassificationEntity courseClassificationEntity = new CourseClassificationEntity();
            courseClassificationEntity.setId(i);
            courseClassificationEntity.setCourseName("测试测试测试测试测试测试测试"+i);
            courseClassificationEntity.setDisplayOrder(i);
            if(i%2 == 0){
                courseClassificationEntity.setState(1);
            }else{
                courseClassificationEntity.setState(2);
            }
            courseClassificationEntity.setUpdateTime(new Date(System.currentTimeMillis()));
            courseClassificationEntity.setCreateTime(new Date(System.currentTimeMillis()));
            courseClassificationEntitiesList.add(courseClassificationEntity);
        }
        ajaxResponseJQueryDt.setDraw(ajaxRequestJQueryDt.getDraw());
        ajaxResponseJQueryDt.setRecordsTotal(11);
        ajaxResponseJQueryDt.setRecordsFiltered(11);
        ajaxResponseJQueryDt.setData(courseClassificationEntitiesList);
        return ajaxResponseJQueryDt;
    }

    @RequestMapping(params = "save")
    @ResponseBody
    public AjaxJson save(CourseClassificationEntity courseClassificationEntity, HttpServletRequest request, HttpServletResponse response) {
        AjaxJson ajaxJson = new AjaxJson();
        Integer code = courseClassificationService.save(courseClassificationEntity);
        if(code <= 0){
            //ajaxJson.setCode(AjaxJson.CODE_FAIL);
            ajaxJson.setMsg(AjaxJson.MSG_FAIL);
        }
        return ajaxJson;
    }


}
