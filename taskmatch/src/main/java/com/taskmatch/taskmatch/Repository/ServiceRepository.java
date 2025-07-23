package com.taskmatch.taskmatch.Repository;

import com.taskmatch.taskmatch.Model.ServiceModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface ServiceRepository extends MongoRepository<ServiceModel, String> {
}
