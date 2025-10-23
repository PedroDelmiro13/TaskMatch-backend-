package com.taskmatch.taskmatch.Repository;

import com.taskmatch.taskmatch.Model.MessageModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface MessageRepository extends MongoRepository<MessageModel, String> {
}
