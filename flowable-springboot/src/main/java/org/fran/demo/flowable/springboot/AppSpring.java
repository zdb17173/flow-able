package org.fran.demo.flowable.springboot;

import org.fran.demo.flowable.springboot.dao.DaoLibrary;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fran
 * @Description
 * @Date 2022/5/16 23:37
 */
@SpringBootApplication(
        scanBasePackageClasses = {AppSpring.class, DaoLibrary.class}
)
public class AppSpring {

    public static void main(String[] args) {
        SpringApplication.run(AppSpring.class, args);
    }
}
