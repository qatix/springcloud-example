package com.qatix.ms.zkconfigclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zk")
@RefreshScope
public class ZkController {

    @Autowired
    private Environment environment;


    @Value("${name}")
    private String name;


    @GetMapping("/name")
    public String getName() {
        return this.name;
    }

    @GetMapping("/env")
    public String getEnv(@RequestParam(name = "key", defaultValue = "name") String key) {
        return environment.getProperty(key);
    }
}
