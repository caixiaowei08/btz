package com.btz.web.system.manager.pojo;

import com.btz.web.system.account.entity.AccountEntity;

import java.util.Date;

/**
 * 在线用户对象
 * Created by User on 2017/5/15.
 */
public class Client implements java.io.Serializable {


    private AccountEntity managerAccount;

    /**
     * 用户IP
     */
    private java.lang.String ip;

    /**
     *登录时间
     */
    private Date logindatetime;

    public AccountEntity getManagerAccount() {
        return managerAccount;
    }

    public void setManagerAccount(AccountEntity managerAccount) {
        this.managerAccount = managerAccount;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLogindatetime() {
        return logindatetime;
    }

    public void setLogindatetime(Date logindatetime) {
        this.logindatetime = logindatetime;
    }
}
