package bg.kirilov.company.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author kirilov_a
 */
@SpringBootApplication
@EnableJpaRepositories("bg.kirilov.company.model")
@EntityScan(basePackages = {"bg.kirilov.company.model"}, basePackageClasses = {Jsr310JpaConverters.class})
//@ComponentScan({"bg.kirilov.company.model","bg.kirilov.company.web"})
public class CompanyWebApp {
    public static void main(String[] args) {
        SpringApplication.run(CompanyWebApp.class, args);
    }
}
