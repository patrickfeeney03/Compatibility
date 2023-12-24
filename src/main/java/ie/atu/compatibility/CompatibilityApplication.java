package ie.atu.compatibility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CompatibilityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompatibilityApplication.class, args);
    }

}
