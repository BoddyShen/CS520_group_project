package com.group.AccountService.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.group.AccountService.model.Message;

public interface MessageRepository extends MongoRepository<Message, ObjectId> {

}