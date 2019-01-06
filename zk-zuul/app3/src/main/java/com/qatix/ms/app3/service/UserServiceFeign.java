package com.qatix.ms.app3.service;

import com.qatix.ms.app3.fallback.UserFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "app2", fallback = UserFeignFallback.class)
public interface UserServiceFeign {
    @RequestMapping("/user/list")
    String getUserList();

//    @GetMapping("/get/{id}")
//    String getUser(@PathVariable int id);
}
