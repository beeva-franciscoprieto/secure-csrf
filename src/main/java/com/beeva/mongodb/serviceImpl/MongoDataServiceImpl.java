package com.beeva.mongodb.serviceImpl;

import com.beeva.mongodb.model.Account;
import com.beeva.mongodb.model.User;
import com.beeva.mongodb.service.DataService;
import com.beeva.mongodb.service.MongoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class MongoDataServiceImpl implements DataService {

    /** Logger */
    private static Logger logger = LoggerFactory.getLogger(MongoDataServiceImpl.class);

    /** Mongo Spring Template Object Mapper */
    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoDataServiceImpl(MongoTemplate mongoTemplate) {

        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public User loadUserByEmail(String email) {

        return (User) loadDataById(User.class, email);
    }

    private MongoEntity loadDataById(Class<?> clazz, String id)  {

        logger.debug("Load Data in " + clazz + " id:" + id);
        return (MongoEntity) mongoTemplate.findById(id, clazz);
    }

    @Override
    public void saveAccount(Account account) {

        mongoTemplate.save(account);
    }

    @Override
    public List<Account> getAccounts(String userId){

        Query query = new Query().addCriteria(Criteria.where("userId").is(userId));
        return mongoTemplate.find(query, Account.class);

    }

    @Override
    public List<Account> getDefaultAccount(String userId){

        Query query = new Query().addCriteria(Criteria.where("userId").is(userId).and("favorite").is(true));
        return mongoTemplate.find(query, Account.class);

    }

}
