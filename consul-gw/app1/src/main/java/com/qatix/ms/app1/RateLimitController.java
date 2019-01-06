package com.qatix.ms.app1;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/rate")
public class RateLimitController {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private static final RateLimiter rateLimiter = RateLimiter.create(2);

    @GetMapping("/t1")
    public String getOne() {
        if (rateLimiter.tryAcquire()) { //one per time
            System.out.println(sdf.format(new Date()));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "rate-OK";
        } else {
            System.out.println("rate limited");
            return "rate-limited";
        }
    }

    @GetMapping("/t5")
    public String getFive() {
        rateLimiter.acquire(5);
        System.out.println(sdf.format(new Date()));
        return "got-5-permits";
    }

}
