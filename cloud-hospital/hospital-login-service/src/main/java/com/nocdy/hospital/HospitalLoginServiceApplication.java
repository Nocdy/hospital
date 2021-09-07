package com.nocdy.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HospitalLoginServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalLoginServiceApplication.class, args);
    }

}