package com.qatix.ms.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qatix.ms.provider.GreetingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference(version = "${demo.service.version}")
    private GreetingService greetingService;

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam(name = "name") String name) {
        return greetingService.sayHi(name);
    }
}
