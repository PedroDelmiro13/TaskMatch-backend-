package com.taskmatch.taskmatch.Repository;

import com.taskmatch.taskmatch.Model.TaskModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Optional;

@EnableMongoRepositories
public interface TaskRepository extends MongoRepository<TaskModel, String> {
    Optional<TaskModel> findByTaskIdAndIsActiveTrue(String id);
    List<TaskModel> findAllByIsActiveTrue();
}
