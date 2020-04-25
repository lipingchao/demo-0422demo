package com.example.demo0422demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * The type Demo 0422 demo application.
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.example.demo0422demo.dao")
public class Demo0422demoApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Demo0422demoApplication.class, args);
    }

}
