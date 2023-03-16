package org.fran.demo.drools.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackageClasses = {AppDroolsSpring.class}
)
public class AppDroolsSpring {
    public static void main(String[] args) {
        SpringApplication.run(AppDroolsSpring.class, args);
    }
}