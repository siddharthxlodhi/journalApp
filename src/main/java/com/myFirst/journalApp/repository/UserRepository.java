package com.myFirst.journalApp.repository;

import com.myFirst.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@Component
public interface UserRepository extends MongoRepository<User, String> {
    User findByUserName(String userName);

}
