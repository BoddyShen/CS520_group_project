package com.group.MatchService.repository;

import com.group.MatchService.model.Profile;
import com.group.MatchService.model.User;
import com.group.MatchService.repository.ProfileRepository;
import com.group.MatchService.model.Preference;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, ObjectId> {
}
