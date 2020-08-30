package cn.aura.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "MICROCLOUD-PROVIDER-PRODUCT")
public interface FeignService {

    @RequestMapping("/product/get/{id}")
    public String getProduct(@PathVariable("id")long id);
}
