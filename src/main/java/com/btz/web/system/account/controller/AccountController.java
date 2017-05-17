package com.btz.web.system.account.controller;

import com.btz.web.constant.State;
import com.btz.web.system.account.entity.AccountEntity;
import com.btz.web.system.account.pojo.Account;
import com.btz.web.system.account.service.AccountService;
import com.btz.web.system.global.service.GlobalService;
import com.btz.web.system.manager.ClientManager;
import com.btz.web.system.manager.pojo.Client;
import org.baron.framework.component.vo.AjaxJson;
import org.baron.framework.core.ssh.controller.BaseController;
import org.baron.framework.utils.ContextHolderUtils;
import org.baron.framework.utils.IpUtil;
import org.baron.framework.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by User on 2017/5/11.
 */
@Controller
@RequestMapping("accountController")
public class AccountController extends BaseController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private GlobalService globalService;

    @RequestMapping(params = "checkuser")
    @ResponseBody
    public AjaxJson checkAccount(@RequestBody AccountEntity accountEntity, HttpServletRequest req){
        AjaxJson ajaxJson = new AjaxJson();
        if(!StringUtils.hasText(accountEntity.getAccountId())){
            ajaxJson.setSuccess(AjaxJson.CODE_FAIL);
            ajaxJson.setMsg("请输入登录账户");
            return ajaxJson;
        }
        if(!StringUtils.hasText(accountEntity.getAccountPwd())){
            ajaxJson.setSuccess(AjaxJson.CODE_FAIL);
            ajaxJson.setMsg("请输入登录密码");
            return ajaxJson;
        }
        AccountEntity accountDb = accountService.doFind(accountEntity);

        if(accountDb == null){
            ajaxJson.setSuccess(AjaxJson.CODE_FAIL);
            ajaxJson.setMsg("账户或者密码错误");
            return ajaxJson;
        }

        if(accountDb.getState().equals(State.VALID.getCode())){
            HttpSession session =  ContextHolderUtils.getSession();
            Client client = new Client();
            client.setIp(IpUtil.getIpAddr(req));
            client.setLogindatetime(new Date());
            accountDb.setAccountPwd(null);
            client.setManagerAccount(accountDb);
            ClientManager.getInstance().addClinet(session.getId(),client);
            ajaxJson.setContent(client);
            return ajaxJson;
        }else {
            ajaxJson.setSuccess(AjaxJson.CODE_FAIL);
            ajaxJson.setMsg("账户已失效");
            return ajaxJson;
        }
    }

    @RequestMapping(params = "doAdd")
    @ResponseBody
    public AjaxJson doAdd(AccountEntity accountEntity, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        if(globalService.isThereAdministratorRights()){
            try{
                accountEntity.setCreateTime(new Date());
                accountEntity.setUpdateTime(new Date());
                accountService.doAdd(accountEntity);
            }catch(Exception e){
                j.setSuccess(AjaxJson.CODE_FAIL);
                j.setMsg("保存失败！");
            }
        }
        return j;
    }

    @RequestMapping(params = "doUpdatePwd")
    @ResponseBody
    public AjaxJson doUpdatePwd(@RequestBody Account account, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        Client client = ClientManager.getInstance().getClient();
        if(client == null||client.getManagerAccount()==null||client.getManagerAccount().getId()==null){
            j.setSuccess(AjaxJson.CODE_FAIL);
            j.setMsg("请重新登录，之后再试！");
            return j;
        }
        AccountEntity  t = accountService.doGet(client.getManagerAccount().getId());
        if(t == null){
            j.setSuccess(AjaxJson.CODE_FAIL);
            j.setMsg("账户不存在！");
            return j;
        }
        int i = 0;
        if(t.getAccountPwd().equals(PasswordUtil.getMD5Encryp(account.getOldAccountPwd()))){
            account.setNewAccountPwd(PasswordUtil.getMD5Encryp(account.getNewAccountPwd()));
            account.setId(t.getId());
            i = accountService.doUpdatePwd(account);
       }else{
            j.setSuccess(AjaxJson.CODE_FAIL);
            j.setMsg("账号或者密码错误！");
            return j;
       }

        if(i>0){
            j.setSuccess(AjaxJson.CODE_SUCCESS);
            j.setMsg("密码修改成功！");
            return j;
        }
        j.setSuccess(AjaxJson.CODE_FAIL);
        j.setMsg("未知错误！");
        return j;
    }

    @RequestMapping(params = "doUpdate")
    @ResponseBody
    public AjaxJson doUpdate(AccountEntity accountEntity, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        if(globalService.isThereAdministratorRights()){
            AccountEntity  t = accountService.doGet(accountEntity.getId());
            if (t == null) {
                j.setSuccess(AjaxJson.CODE_FAIL);
                j.setMsg("系统不存在该条数据！");
                return j;
            }
            try{
                accountService.doAdd(accountEntity);
            }catch(Exception e){
                j.setSuccess(AjaxJson.CODE_FAIL);
                j.setMsg("保存失败！");
            }
        }else{
            j.setSuccess(AjaxJson.CODE_FAIL);
            j.setMsg("该账户无管理员权限");
        }
        return j;
    }

    @RequestMapping(params = "doDel")
    @ResponseBody
    public AjaxJson doDel(AccountEntity accountEntity, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        if(globalService.isThereAdministratorRights()){
            try{
                accountService.doDel(accountEntity);
            }catch(Exception e){
                j.setSuccess(AjaxJson.CODE_FAIL);
                j.setMsg("删除失败！");
                e.printStackTrace();
            }
        }else {
            j.setSuccess(AjaxJson.CODE_FAIL);
            j.setMsg("该账户无管理员权限");
        }
        return j;
    }

    @RequestMapping(params = "logOff")
    @ResponseBody
    public AjaxJson logOff(HttpServletRequest request,HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        ClientManager.getInstance().removeClinet(ContextHolderUtils.getSession().getId());//删除系统中的会话变量
        ContextHolderUtils.getSession().invalidate();//删除会话
        return j;
    }

    @RequestMapping(params = "getAccountFromSession")
    @ResponseBody
    public AjaxJson getAccountFromSession(HttpServletRequest request,HttpServletResponse response) {
        AjaxJson j = new AjaxJson();
        Client client = ClientManager.getInstance().getClient();
        if(client == null||client.getManagerAccount() == null){
            j.setSuccess(AjaxJson.CODE_FAIL);
            j.setMsg("账户登录失败，请重新登录！");
            return j;
        }
        j.setContent(client.getManagerAccount());
        return j;
    }
}
