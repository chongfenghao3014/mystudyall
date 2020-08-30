package cn.aura.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "MICROCLOUD-PROVIDER-PRODUCT" ,path = "api")
public interface B2BInOutProvider {
    @RequestMapping("/product/get/{id}")// 虽然注解本身不支持继承，但是在spring中做了改变，子类可以共享接口的
                                        //  请求地址。 这里的path=“api”，那么请求路径就是 api/product/get/22
    public abstract Object getProduct(Long id);
}
