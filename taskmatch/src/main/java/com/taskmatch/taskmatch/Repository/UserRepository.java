package com.taskmatch.taskmatch.Repository;

import com.taskmatch.taskmatch.Model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface UserRepository extends MongoRepository <UserModel, String>{

}
