package com.qatix.ms.app2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Environment environment;

    @GetMapping("/list")
    public Object getList() {
        return new String[]{"Bill", "Jim", "Josh"};
    }

    @GetMapping("/get")
    public String getUser(@RequestParam(name = "id") int id) {
        return String.format("user-%d-info[from-server:%s]", id, environment.getProperty("server.port"));
    }
}
