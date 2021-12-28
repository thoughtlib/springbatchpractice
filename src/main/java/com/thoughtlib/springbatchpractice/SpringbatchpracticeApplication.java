package com.thoughtlib.springbatchpractice;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableBatchProcessing
@EnableScheduling
@SpringBootApplication
public class SpringbatchpracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbatchpracticeApplication.class, args);
    }

}
