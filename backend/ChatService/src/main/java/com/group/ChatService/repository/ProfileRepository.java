package com.group.ChatService.repository;

import com.group.ChatService.model.Profile;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, ObjectId> {
}
