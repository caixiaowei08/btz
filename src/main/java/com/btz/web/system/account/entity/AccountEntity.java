package com.btz.web.system.account.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by User on 2017/4/5.
 */
@Entity
@Table(name = "btz_administrator_account")
public class AccountEntity implements Serializable {
    private Integer id;
    private String accountId;
    private String accountPwd;
    private String accountName;
    private Integer state;
    private Integer role;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id",nullable=false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name ="accountId",nullable=false)
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Column(name ="accountPwd",nullable=false)
    public String getAccountPwd() {
        return accountPwd;
    }

    public void setAccountPwd(String accountPwd) {
        this.accountPwd = accountPwd;
    }

    @Column(name ="accountName",nullable=false)
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Column(name ="state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Column(name ="updateTime")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name ="createTime")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name ="role")
    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
