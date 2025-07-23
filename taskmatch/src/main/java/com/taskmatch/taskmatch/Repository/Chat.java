package com.taskmatch.taskmatch.Repository;

import com.taskmatch.taskmatch.Model.ChatModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface Chat extends MongoRepository <ChatModel, String>{
}
