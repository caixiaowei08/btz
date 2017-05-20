package com.btz.web.user.controller;

import com.btz.web.constant.AccountConstant;
import com.btz.web.constant.State;
import com.btz.web.system.account.entity.AccountEntity;
import com.btz.web.system.manager.pojo.Client;
import com.btz.web.user.entity.UserEntity;
import com.btz.web.user.service.UserService;
import org.baron.framework.component.vo.AjaxJson;
import org.baron.framework.core.common.bootstrapTable.DataUtils;
import org.baron.framework.core.common.hibernate.DataGrid;
import org.baron.framework.core.ssh.controller.BaseController;
import org.baron.framework.utils.ContextHolderUtils;
import org.baron.framework.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 2017/5/19.
 */
@Controller
@RequestMapping("userController")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(params = "checkuser")
    @ResponseBody
    public AjaxJson checkAccount(UserEntity userEntity, HttpServletRequest req){
        AjaxJson ajaxJson = new AjaxJson();
        if(!StringUtils.hasText(userEntity.getUserId())){
            ajaxJson.setSuccess(AjaxJson.CODE_FAIL);
            ajaxJson.setMsg("请输入登录账号！");
            return  ajaxJson;
        }
        if(!StringUtils.hasText(userEntity.getUserPwd())){
            ajaxJson.setSuccess(AjaxJson.CODE_FAIL);
            ajaxJson.setMsg("请输入登录密码！");
            return  ajaxJson;
        }
        UserEntity userDb = userService.checkUser(userEntity);

        if(userDb == null){
            ajaxJson.setSuccess(AjaxJson.CODE_FAIL);
            ajaxJson.setMsg("账户或者密码不正确！");
            return  ajaxJson;
        }
        userDb.setUserPwd("");
        ajaxJson.setContent(userDb);
        return ajaxJson;
    }

    @RequestMapping(params = "datagrid")
    public void datagrid(HttpServletRequest request, HttpServletResponse response,@RequestBody DataGrid dataGrid) {
        DataGrid t = userService.findPageList(dataGrid);
        DataUtils.datagrid(response,t);
    }
}
