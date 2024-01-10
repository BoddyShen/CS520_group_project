package com.group.ChatService.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.bson.types.ObjectId;

import com.group.ChatService.model.Preference;

@Repository
public interface PreferenceRepository extends MongoRepository<Preference, ObjectId> {
    Optional<Preference> findPreferenceByName(String name);
}
