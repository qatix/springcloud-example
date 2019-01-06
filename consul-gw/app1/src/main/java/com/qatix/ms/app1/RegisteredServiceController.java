package com.qatix.ms.app1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reg")
public class RegisteredServiceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/service/{applicationName}")
    public Object getInstance(@PathVariable String applicationName) {
        return discoveryClient.getInstances(applicationName);
    }

    @GetMapping("/services")
    public Object getInstances() {
        return discoveryClient.getServices();
    }

}
