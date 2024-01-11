package com.group.ChatService.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.group.ChatService.model.User;

import java.util.List;

@FeignClient(name="MATCH-SERVICE")
public interface MatchService {


    @GetMapping("/api/v1/match/get-all-matched-users-service/{id}")
    List<User> getMatchedUsersService(@PathVariable String id);

}
