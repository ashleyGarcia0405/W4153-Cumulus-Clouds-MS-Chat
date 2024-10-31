package com.cumulusclouds.w4156cumuluscloudsmschat;

import com.cumulusclouds.w4156cumuluscloudsmschat.client.UserFeignClient;
import com.cumulusclouds.w4156cumuluscloudsmschat.client.MessageFeignClient;
import com.cumulusclouds.w4156cumuluscloudsmschat.dto.MessageDto;
import com.cumulusclouds.w4156cumuluscloudsmschat.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// import java.util.List;

public class RouteController {
    
    private final UserFeignClient userFeignClient;
    private final MessageFeignClient messageFeignClient;

    @Autowired
    public RouteController(UserFeignClient userFeignClient, MessageFeignClient messageFeignClient) {
        this.userFeignClient = userFeignClient;
        this.messageFeignClient = messageFeignClient;
    }

    @GetMapping("/api/chat/user/{accountId}")
    public ResponseEntity<UserDto> getUserProfile(@PathVariable String accountId) {
        UserDto user = userFeignClient.getUserProfile(accountId);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/api/chat/message/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDto messageDto) {
        messageFeignClient.sendMessage(messageDto);
        return ResponseEntity.ok("Message sent successfully");
    }
}
