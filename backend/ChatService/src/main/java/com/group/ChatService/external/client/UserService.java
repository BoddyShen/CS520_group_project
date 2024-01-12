package com.group.ChatService.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import com.group.ChatService.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface UserService {

    @GetMapping("/api/v1/users/{id}")
    User getSingleUser(@PathVariable String id);
}
