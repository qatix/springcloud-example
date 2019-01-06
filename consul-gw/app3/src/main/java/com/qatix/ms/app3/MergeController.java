package com.qatix.ms.app3;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/merge")
public class MergeController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/product")
    public String getProduct(@RequestParam(name = "id") int id) {
        String url = "http://app1/product/get/" + id;
        return this.restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/user")
    public String getUser(@RequestParam(name = "id") int id) {
        String url = String.format("http://app2/user/get?id=%d", id);
        System.out.println(url);
        return this.restTemplate.getForObject(url, String.class);
    }


    @HystrixCommand(fallbackMethod = "getDefaultUsers")
    @GetMapping("/user-list")
    public Object getUserList() {
        String url = "http://app2/user/list";
        return this.restTemplate.getForObject(url, String.class);
    }

    private Object getDefaultUsers() {
        return new String[]{"default-user1", "default-user2", "default-user3"};
    }
}
