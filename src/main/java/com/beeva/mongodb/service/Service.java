package com.beeva.mongodb.service;

import com.beeva.mongodb.form.AccountForm;
import com.beeva.mongodb.model.Account;

import java.util.List;

/**
 * This Interface is the services layer to Mongo DB Entities
 * 
 * @author beeva
 * 
 */
public interface Service {

    void saveAccount(String userId, AccountForm inputData);

    List<Account> getAllAccounts (String userId);

    Account getDefaultAccount (String userId);
}
