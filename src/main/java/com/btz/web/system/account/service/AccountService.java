package com.btz.web.system.account.service;

import com.btz.web.system.account.entity.AccountEntity;
import org.baron.framework.core.ssh.service.BaseService;

import java.io.Serializable;

/**
 * Created by User on 2017/5/12.
 */
public interface AccountService extends BaseService{

    public AccountEntity doFind(AccountEntity accountEntity);

    public AccountEntity doAdd(AccountEntity accountEntity);

    public void doUpdate(AccountEntity accountEntity);

    public void doDel(AccountEntity accountEntity);

    public AccountEntity doGet(Integer id);

}
