package com.qatix.ms.app3.service;

import com.qatix.ms.app3.fallback.ProductFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "app1", fallback = ProductFeignFallback.class)
public interface ProductServiceFeign {
    @RequestMapping("/product/list")
    Object getProductList();

//    @GetMapping("/get/{id}")
//    String getProduct(@PathVariable Integer id);
}
