package com.cumulusclouds.w4156cumuluscloudsmschat.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.cumulusclouds.w4156cumuluscloudsmschat.dto.UserDto;

@FeignClient(name = "user-service", url = "http://USER-SERVICE-URL")
public interface UserFeignClient {

    UserDto getUserProfile(@PathVariable("accountId") String accountId);
}
