package com.enaaskills.briefingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class BriefingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BriefingServiceApplication.class, args);
    }

}
