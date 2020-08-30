package cn.aura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("cn.aura")
public class ConsumerFeignApp {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ConsumerFeignApp.class, args);
    }
}
