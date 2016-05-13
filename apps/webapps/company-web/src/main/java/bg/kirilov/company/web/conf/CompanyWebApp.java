package bg.kirilov.company.web.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author kirilov_a
 */
@SpringBootApplication
@ComponentScan({"bg.kirilov.company.web"})
public class CompanyWebApp {
    public static void main(String[] args) {
        SpringApplication.run(CompanyWebApp.class, args);
    }
}
