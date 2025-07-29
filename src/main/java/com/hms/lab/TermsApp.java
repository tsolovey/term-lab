package com.hms.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TermsApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TermsApp.class, args);
    }

}
