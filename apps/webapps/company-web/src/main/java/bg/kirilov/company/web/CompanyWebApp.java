package bg.kirilov.company.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kirilov_a
 */
@SpringBootApplication
//@ComponentScan({"bg.kirilov.company.web"})
public class CompanyWebApp {
    public static void main(String[] args) {
        SpringApplication.run(CompanyWebApp.class, args);
    }
}
