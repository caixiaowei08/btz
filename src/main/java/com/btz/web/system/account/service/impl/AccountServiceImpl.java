package com.btz.web.system.account.service.impl;

import com.btz.web.system.account.dao.AccountDao;
import com.btz.web.system.account.service.AccountService;
import org.baron.framework.core.ssh.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by User on 2017/5/12.
 */
@Service("accountService")
@Transactional
public class AccountServiceImpl extends BaseServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;





}
