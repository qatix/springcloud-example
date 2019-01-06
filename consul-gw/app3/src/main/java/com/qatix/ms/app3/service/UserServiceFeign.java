package com.qatix.ms.app3.service;

import com.qatix.ms.app3.fallback.UserFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "app2", fallback = UserFeignFallback.class)
public interface UserServiceFeign {
    @RequestMapping("/user/list")
    String getUserList();

    @GetMapping("/user/get")
    String getUser(@RequestParam(name = "id") int id);
}
