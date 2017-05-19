package com.btz.web.system.global.service;

import com.btz.web.system.account.entity.AccountEntity;

/**
 * Created by User on 2017/5/15.
 */
public interface GlobalService {

    public boolean isThereAdministratorRights();

    public AccountEntity getSessionAccount();

}
