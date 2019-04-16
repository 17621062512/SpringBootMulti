package com.leemon.springbootmongodb.repository;

import com.leemon.springbootmongodb.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String name);

}
