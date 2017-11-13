package com.example.demo.repository;

import com.example.demo.bean.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 操作mongo
 * Created by xing on 2017/6/20.
 */
public interface UserMongoRepository extends MongoRepository<User, Long> {

    User findByName(String name);

}
