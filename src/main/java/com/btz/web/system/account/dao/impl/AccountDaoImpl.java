package com.btz.web.system.account.dao.impl;

import com.btz.web.system.account.dao.AccountDao;
import com.btz.web.system.account.entity.AccountEntity;
import com.btz.web.system.account.pojo.Account;
import org.baron.framework.core.ssh.dao.impl.BaseDaoImpl;
import org.baron.framework.utils.PasswordUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by User on 2017/5/12.
 */
@Repository("accountDao")
public class AccountDaoImpl extends BaseDaoImpl implements AccountDao {

    public AccountEntity checkAccount(String accountId,String accountPwd){
        String HQL= new String("from AccountEntity u where u.accountId = :accountId and u.accountPwd=:accountPwd");
        Session session = getSession();
        Query query = session.createQuery(HQL);
        query.setParameter("accountId", accountId);
        query.setParameter("accountPwd", PasswordUtil.getMD5Encryp(accountPwd));
        List<AccountEntity> accountList = query.list();
        if(CollectionUtils.isEmpty(accountList)){
             return null;
        }
        return accountList.get(0);
    }

    public int doUpdatePwd(Account account) {
        String HQL= new String("update AccountEntity u set u.accountPwd=:newAccountPwd where u.id=:id");
        Session session = getSession();
        Query query = session.createQuery(HQL);
        query.setParameter("id", account.getId());
        query.setParameter("newAccountPwd",account.getNewAccountPwd());
        return query.executeUpdate();
    }

}
