package com.qatix.ms.app1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private Environment environment;

    @GetMapping("/list")
    public Object getList(){
        return new String[]{"iPhoneX","Mi6","P20"};
    }

    @GetMapping("/get/{id}")
    public String getProduct(@PathVariable int id){
        return String.format("product-%d-info[from-server:%s]", id,environment.getProperty("server.port"));
    }
}
