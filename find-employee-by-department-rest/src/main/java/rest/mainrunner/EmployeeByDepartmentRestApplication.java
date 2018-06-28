package rest.mainrunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication(scanBasePackages = {"rest", "model"})
public class EmployeeByDepartmentRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeByDepartmentRestApplication.class, args);
    }
}