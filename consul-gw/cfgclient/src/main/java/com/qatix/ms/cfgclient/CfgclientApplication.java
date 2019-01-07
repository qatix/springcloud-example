package com.qatix.ms.cfgclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CfgclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CfgclientApplication.class, args);
    }

}

