package com.taskmatch.taskmatch.Repository;

import com.taskmatch.taskmatch.Model.ChatModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ChatRepository extends MongoRepository<ChatModel, String> {
    List<ChatModel> findByUserId(String userId);
}