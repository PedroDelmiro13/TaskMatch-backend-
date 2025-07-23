package com.taskmatch.taskmatch.Repository;

import com.taskmatch.taskmatch.Model.AppointmentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface AppointmentRepository extends MongoRepository<AppointmentModel, String> {
}
