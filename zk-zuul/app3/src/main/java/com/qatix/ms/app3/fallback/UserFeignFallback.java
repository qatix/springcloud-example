package com.qatix.ms.app3.fallback;

import com.qatix.ms.app3.service.UserServiceFeign;
import org.springframework.stereotype.Component;

@Component
public class UserFeignFallback implements UserServiceFeign {
    @Override
    public String getUserList() {
        return "getUserList-fallback";
    }
//
//    @Override
//    public String getUser(int id) {
//        return String.format("getUser-%d-fallback", id);
//    }
}
