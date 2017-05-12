package com.btz.web.system.account.controller;

import com.btz.web.system.account.entity.AccountEntity;
import org.baron.framework.component.vo.AjaxJson;
import org.baron.framework.core.ssh.controller.BaseController;
import org.baron.framework.utils.ContextHolderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.baron.framework.utils.ContextHolderUtils.getSession;

/**
 * Created by User on 2017/5/11.
 */
@Controller
@RequestMapping("accountController")
public class AccountController extends BaseController {

    @RequestMapping(params = "checkuser")
    @ResponseBody
    public AjaxJson checkAccount(AccountEntity accountEntity, HttpServletRequest req){
        AjaxJson ajaxJson = new AjaxJson();
        HttpSession session =  ContextHolderUtils.getSession();
        return ajaxJson;
    }
}
