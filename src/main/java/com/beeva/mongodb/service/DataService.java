package com.beeva.mongodb.service;

import com.beeva.mongodb.model.Account;
import com.beeva.mongodb.model.User;

import java.util.List;

/**
 * This Interface is the services layer to Mongo DB Entities
 * 
 * @author beeva
 * 
 */
public interface DataService {

    User loadUserByEmail(String email);

    void saveAccount(Account message);

    List<Account> getAccounts (String userId);

    List<Account> getDefaultAccount(String userId);

    }
