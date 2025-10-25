package com.taskmatch.taskmatch.Repository;

import com.taskmatch.taskmatch.Model.MessageModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Optional;

@EnableMongoRepositories
public interface MessageRepository extends MongoRepository<MessageModel, String> {
    Optional<MessageModel>findByMessageIdAndIsDeletedIsFalse(String messageId);
    List<MessageModel>findAllByIsDeletedIsFalse();
}
