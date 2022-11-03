package cms.bpm.flowable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackageClasses = {BpmApp.class}
)
public class BpmApp {

    public static void main(String[] args){
        SpringApplication.run(BpmApp.class, args);
    }
}
