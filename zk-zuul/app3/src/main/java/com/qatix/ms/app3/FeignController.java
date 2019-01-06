package com.qatix.ms.app3;

import com.qatix.ms.app3.service.ProductServiceFeign;
import com.qatix.ms.app3.service.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private ProductServiceFeign productService;

    @Autowired
    private UserServiceFeign userService;

    @GetMapping("/product/list")
    public Object getProductList() {
        return productService.getProductList();
    }

//    @GetMapping("/product/get/{id}")
//    public Object getProduct(@PathVariable int id) {
//        return productService.getProduct(id);
//    }
//
    @GetMapping("/user/list")
    public Object getUserList() {
        return userService.getUserList();
    }
//
//    @GetMapping("/user/get")
//    public Object getUser(@RequestParam(name = "id") int id) {
//        return userService.getUser(id);
//    }

}
