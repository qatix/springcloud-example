package com.qatix.ms.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qatix.ms.provider.GreetingService;

@Service(version = "${demo.service.version}")
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayHi(String name) {
        return "Hello " + name + "[by dubbo]";
    }
}
