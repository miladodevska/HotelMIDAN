package com.example.midan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
public class MidanApplication {

    public static void main(String[] args) {
        SpringApplication.run(MidanApplication.class, args);
    }


}
