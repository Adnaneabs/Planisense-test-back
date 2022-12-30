package com.test.test_planisense_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TestPlanisenseBack {

    public static void main(String[] args) {
        SpringApplication.run(TestPlanisenseBack.class, args);
    }

}
