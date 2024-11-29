package com.dipartimento.ristorantitwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class RistorantiTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RistorantiTwoApplication.class, args);
    }

}
