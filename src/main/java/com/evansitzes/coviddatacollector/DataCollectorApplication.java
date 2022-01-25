package com.evansitzes.coviddatacollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DataCollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataCollectorApplication.class, args);
    }

}
