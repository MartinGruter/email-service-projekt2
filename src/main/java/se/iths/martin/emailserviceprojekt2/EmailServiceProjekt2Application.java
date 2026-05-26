package se.iths.martin.emailserviceprojekt2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "se.iths.martin"
})
public class EmailServiceProjekt2Application {

    public static void main(String[] args) {
        SpringApplication.run(EmailServiceProjekt2Application.class, args);
    }

}
