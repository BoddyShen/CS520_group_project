package com.group.MatchService.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import com.group.MatchService.model.UserWithConversationData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@FeignClient(name = "CHAT-SERVICE")
public interface ChatService {

    @GetMapping("/api/v1/conversation/get-matched-users-with-conversation-data-service/{id}")
    List<UserWithConversationData> getMatchedUsersWithConversationData(@PathVariable String id);
}
