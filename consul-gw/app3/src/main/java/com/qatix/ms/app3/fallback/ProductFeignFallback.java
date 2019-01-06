package com.qatix.ms.app3.fallback;

import com.qatix.ms.app3.service.ProductServiceFeign;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignFallback implements ProductServiceFeign {
    @Override
    public String getProductList() {
        return "getProductList-fallback";
    }

    @Override
    public String getProduct(int id) {
        return String.format("getProduct-%d-fallback", id);
    }
}
