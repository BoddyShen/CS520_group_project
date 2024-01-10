package com.group.MatchService.external.client;

import com.group.MatchService.model.MatchCreateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ACCOUNT_SERVICE/")
public interface UserService {

    @PostMapping("/match")
    void createMatch(@RequestBody MatchCreateRequest request);

}
