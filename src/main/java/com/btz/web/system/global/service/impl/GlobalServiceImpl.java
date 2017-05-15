package com.btz.web.system.global.service.impl;

import com.btz.web.constant.Role;
import com.btz.web.system.account.entity.AccountEntity;
import com.btz.web.system.account.service.AccountService;
import com.btz.web.system.global.service.GlobalService;
import com.btz.web.system.manager.ClientManager;
import com.btz.web.system.manager.pojo.Client;
import org.baron.framework.utils.ContextHolderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * Created by User on 2017/5/15.
 */
@Service("globalService")
@Transactional
public class GlobalServiceImpl implements GlobalService {

    @Autowired
    private AccountService accountService;

    public boolean isThereAdministratorRights() {
        HttpSession session = ContextHolderUtils.getSession();
        if (session == null) {
            return false;
        }
        Client client = ClientManager.getInstance().getClient(session.getId());
        AccountEntity accountEntity = client.getManagerAccount();

        if (accountEntity == null||accountEntity.getId() == null) {
            return false;
        }
        accountEntity = accountService.doGet(accountEntity.getId());

        if(accountEntity == null){
            return false;
        }

        if(accountEntity.getRole().equals(Role.ADMIN.getCode())){
            return true;
        }

        return false;
    }
}
