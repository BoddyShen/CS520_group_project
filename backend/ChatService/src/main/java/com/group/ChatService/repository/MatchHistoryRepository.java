package com.group.ChatService.repository;
import com.group.ChatService.model.MatchHistory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchHistoryRepository extends MongoRepository<MatchHistory, ObjectId> {
}
