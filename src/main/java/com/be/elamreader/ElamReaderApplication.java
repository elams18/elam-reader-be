package com.be.elamreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.be.elamreader")
public class ElamReaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElamReaderApplication.class, args);
    }

}
