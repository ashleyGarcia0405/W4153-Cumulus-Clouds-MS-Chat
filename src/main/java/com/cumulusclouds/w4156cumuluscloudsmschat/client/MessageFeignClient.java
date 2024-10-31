package com.cumulusclouds.w4156cumuluscloudsmschat.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import com.cumulusclouds.w4156cumuluscloudsmschat.dto.MessageDto;

@FeignClient(name = "message-service", url = "http://MESSAGE-SERVICE-URL")
public interface MessageFeignClient {

    @PostMapping("/message/send")
    void sendMessage(@RequestBody MessageDto messageDto);

    @GetMapping("/conversation/{conversationId}/messages")
    List<MessageDto> getConversationMessages(@PathVariable("conversationId") String conversationId);
}
