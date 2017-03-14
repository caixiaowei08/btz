package org.btz.test.controller;

import org.btz.test.entity.AjaxEntity;
import org.btz.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by User on 2017/3/12.
 */
@Controller
@RequestMapping("testController")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(params = "test")
    @ResponseBody
    public AjaxEntity test(AjaxEntity ajaxEntity, HttpServletRequest request, HttpServletResponse response) {
        testService.test();
        return ajaxEntity;
    }

    @RequestMapping(params = "index")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return "login/login";
    }

    @RequestMapping(params = "ajax")
    public String ajax(HttpServletRequest request, HttpServletResponse response) {

        return "test/ajaxJson";
    }


}
