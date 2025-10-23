package com.taskmatch.taskmatch.Repository;

import com.taskmatch.taskmatch.Model.PaymentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface PaymentRepository extends MongoRepository<PaymentModel, String> {
}
