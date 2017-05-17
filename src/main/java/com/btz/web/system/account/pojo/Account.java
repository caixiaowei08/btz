package com.btz.web.system.account.pojo;

import java.io.Serializable;

/**
 * Created by User on 2017/5/17.
 */
public class Account implements Serializable {

    private Integer id;
    private String accountId;
    private String oldAccountPwd;
    private String newAccountPwd;
    private String accountName;
    private Integer state;
    private Integer role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getOldAccountPwd() {
        return oldAccountPwd;
    }

    public void setOldAccountPwd(String oldAccountPwd) {
        this.oldAccountPwd = oldAccountPwd;
    }

    public String getNewAccountPwd() {
        return newAccountPwd;
    }

    public void setNewAccountPwd(String newAccountPwd) {
        this.newAccountPwd = newAccountPwd;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
