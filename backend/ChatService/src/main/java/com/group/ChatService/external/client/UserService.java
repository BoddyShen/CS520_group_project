package com.group.ChatService.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import com.group.ChatService.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ACCOUNT_SERVICE/api/v1/user")
public interface UserService {

    @GetMapping("/{id}")
    User getSingleUser(@PathVariable String id);
}
