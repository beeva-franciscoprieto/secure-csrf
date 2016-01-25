package com.beeva.mongodb.serviceImpl;

import com.beeva.mongodb.form.AccountForm;
import com.beeva.mongodb.model.Account;
import com.beeva.mongodb.service.DataService;
import com.beeva.mongodb.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Component
public class ServiceImpl implements Service {


    public static final String OPT_SECURE = "/opt/secure/";
    public static final int ROLE_USER = 2;
    /** Logger */
    private static Logger logger = LoggerFactory.getLogger(ServiceImpl.class);

    private DataService dataService;

    @Autowired
    public ServiceImpl(DataService dataService) {

        this.dataService = dataService;
    }


    @Override
    public void saveAccount(String userId, AccountForm inputData) {

        Account account = new Account();
        account.setAccountNumber(inputData.getAccountNumber());
        account.setFavorite(inputData.isFavorite());
        account.setDate(new Date(System.currentTimeMillis()));
        account.setUserId(userId);

        dataService.saveAccount(account);
    }

    @Override
    public List<Account> getAllAccounts (String userId){

        List<Account> accounts = dataService.getAccounts(userId);
        return accounts;
    }

    @Override
    public Account getDefaultAccount (String userId){

        List<Account> accounts = dataService.getDefaultAccount(userId);
        return  accounts.get(0);
    }

}
