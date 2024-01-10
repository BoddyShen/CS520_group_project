package com.group.MatchService.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.group.MatchService.model.Message;

public interface MessageRepository extends MongoRepository<Message, ObjectId> {

}