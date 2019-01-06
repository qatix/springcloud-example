package com.qatix.ms.app1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/bad")
public class BadController {

    @GetMapping("/get")
    public String bad() {
        log.info("bad request test");
        throw new IllegalArgumentException("param missing");
    }
}
