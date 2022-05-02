package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainClass {
    private static final Logger log = LoggerFactory.getLogger(MainClass.class);

    public static void main(String[] args) {
        log.debug("App is up!");
        SpringApplication.run(MainClass.class, args);
    }
}
