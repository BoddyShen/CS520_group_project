package com.group.ChatService.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.group.ChatService.model.User;

import java.util.List;

@FeignClient(name="MATCH_SERVICE/api/v1/match")
public interface MatchService {


    @GetMapping("/get-all-matched-users-service/{id}")
    List<User> getMatchedUsersService(@PathVariable String id);

}
