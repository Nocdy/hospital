package com.nocdy.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HospitalPatientRecordServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalPatientRecordServiceApplication.class, args);
    }

}
