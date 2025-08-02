package com.taskmatch.taskmatch.Repository;

import com.taskmatch.taskmatch.Model.TaskModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface TaskRepository extends MongoRepository<TaskModel, String> {
}
