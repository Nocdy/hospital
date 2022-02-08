package com.nocdy.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HospitalRegisterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalRegisterServiceApplication.class, args);
    }

}
