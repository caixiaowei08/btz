package com.btz.app.user.controller;

import com.btz.web.user.entity.UserEntity;
import com.btz.web.user.service.UserService;
import org.baron.framework.component.vo.AjaxJson;
import org.baron.framework.core.ssh.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 2017/5/19.
 */
@Controller
@RequestMapping("appUserController")
public class AppUserController extends BaseController {

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
}
