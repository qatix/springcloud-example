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

    //@PathVariable形式的参数,则要用value=""标明对应的参数,否则会抛出IllegalStateException异常
    @GetMapping("/product/get/{id}")
    String getProduct(@PathVariable(value = "id") int id);
}
