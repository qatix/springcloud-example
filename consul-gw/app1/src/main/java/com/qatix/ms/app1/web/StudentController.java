package com.qatix.ms.app1.web;

import com.qatix.ms.app1.config.StudentConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Value("${myName}")
    private String myName;

    @Autowired
    private StudentConfig studentConfig;

    @RequestMapping("/myname")
    public String testHello(){
        System.out.println("my name is : "+myName);
        return myName;
    }

    @RequestMapping("/config")
    public String testConfig(){
        System.out.println(studentConfig.toString());
        return studentConfig.toString();
    }



}
