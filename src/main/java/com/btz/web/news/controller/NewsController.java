package com.btz.web.news.controller;

import com.btz.web.news.entity.NewsEntity;
import com.btz.web.news.service.NewsService;
import com.btz.web.system.account.entity.AccountEntity;
import org.baron.framework.component.vo.AjaxJson;
import org.baron.framework.core.common.hibernate.DataGrid;
import org.baron.framework.core.ssh.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by User on 2017/5/20.
 */
@Controller
@RequestMapping("newsController")
public class NewsController extends BaseController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(params = "datagrid")
    public void datagrid(NewsEntity newsEntity, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

    }

    @RequestMapping(params = "doAdd")
    @ResponseBody
    public AjaxJson doAdd(NewsEntity newsEntity, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        try{
            newsService.doAdd(newsEntity);
        }catch (Exception e){
            j.setSuccess(AjaxJson.CODE_FAIL);
            j.setMsg("新增失败！");
        }
        return j;
    }

    @RequestMapping(params = "doDel")
    @ResponseBody
    public AjaxJson doDel(NewsEntity newsEntity, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        return  j;

    }

    @RequestMapping(params = "doUpdate")
    @ResponseBody
    public AjaxJson doUpdate(NewsEntity newsEntity, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        return  j;
    }
}
