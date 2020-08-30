package cn.test.springboot.controller;

import cn.test.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired(required = false)
    TestService testService;
    @RequestMapping("/test")
    public String test(){
        return testService.test();
    }
}
