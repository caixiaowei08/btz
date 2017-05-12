package com.btz.web.system.account.dao;

import com.btz.web.system.account.entity.AccountEntity;
import org.baron.framework.core.ssh.dao.BaseDao;

/**
 * Created by User on 2017/5/12.
 */
public interface AccountDao extends BaseDao {


    public AccountEntity checkAccount(String AccountId,String AccountPWD);
}
