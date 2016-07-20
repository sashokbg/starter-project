#Starter Project

This project intends to provide a good starting point for developing multi modular spring boot applications.
It is based around an employees/products/customers paradigm.
 
## Project Structure

The project is intended to be highly modular and provide a **core**, **business** and **webapps** modules, each
 having its own responsibilities.

* Core

    Includes the model and repositories, accessing the model objects
    
* Business

    Includes the business services, defining business rules and validations
    
* Webapps
    
   Includes the different endpoints that expose the data to the user. This includes 
   a REST service, a simple single-paged JS application (angular2 ?) and a simple multipage webapp
    based on Thymeleaf templates and Spring MVC

## Technologies

The project aims to be 100% based on spring boot and spring boot oriented technologies
and their JEE equivalents (JPA, Bean Validation and so on)
 
* Spring Boot
* Spring Data
* Thymeleaf
* MySQL (H2 ?)

## Model Mapping

The project's model is based on the following MySQL sample database: 
http://www.mysqltutorial.org/mysql-sample-database.aspx

The ORM mapping is done, using JPA 2.1 and Spring Data (CRUD repositories).

The database is instantiated using spring boot's auto import feature. See files ***data-mysql.sql*** and ***schema-mysql.sql*** and their 
relevant configuration in ***application.yml***.

See http://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html#howto-initialize-a-database-using-spring-jdbc

```properties
spring:
  jpa:
    show-sql: true
    generate-ddl: false
    hibernate:
      format_sql: true
      dialect: org.hibernate.dialect.MySQL5Dialect
      naming-strategy: org.hibernate.cfg.EJB3NamingStrategy
  datasource:
    platform: mysql
    url: jdbc:mysql://localhost/classicmodels
    username: root
    password: root
    driver-class-name: com.mysql.jdbc.Driver
    initialize: false
```

Note that the naming strategy is required in order to make camel case column names work.
Ex: @Column("orderDetails"), since Spring Data ignores JPA's default strategies.

### ORM and LocalDate

In order to make Spring data (hibernate is the underlying implementation) to work with 
JSR-310 LocalDate instead of old Date objects, we need to include ***Jsr310JpaConverters.class*** to our spring configuration:

```java
@SpringBootApplication
@EnableJpaRepositories("bg.kirilov.company.model")
@EntityScan(basePackages = {"bg.kirilov.company.model"}, basePackageClasses = {Jsr310JpaConverters.class})
public class CompanyWebApp {
    public static void main(String[] args) {
        SpringApplication.run(CompanyWebApp.class, args);
    }
}
```

### Loading JPA repository from different module

In order to load and activate JPA repositories for Spring Data that are located in a different
module (ex: *core/model* is loaded in *webapps/company-web*), we need to use @EntityScan and @EnableJpaRepositories
for a specific package. @EntityScan Should not be mistaken for @ComponentScan !

### ORM N+1 Queries problem

A common problem when using ORM mapping is that we do not control the number of 
queries nor the joins that the underlying implementation of JPA is creating.

This results often in the so called *N+1* problem, where we create one query for
loading our main object (ex Order) and *N* queries for all its children (ex OrderDetail).
 In order to handle this problem we can define @NamedEntityGraph as of JPA 2.1 in
 order to specify the complete graph to be loaded for our query.
 
 In Spring Data we need to specify what EntityGraph is needed in the Repository:
 
 ```java
 public interface OrdersRepository extends Repository<Order, Long> {
     @EntityGraph(value = "graph.Order.details", type = EntityGraph.EntityGraphType.LOAD)
     List<Order> findAll();
     List<Order> findByNumber(Long number);
 }
 ```
 
 For more information:
 
 https://docs.oracle.com/javaee/7/tutorial/persistence-entitygraphs002.htm
 
 https://martinsdeveloperworld.wordpress.com/2014/07/02/using-namedentitygraph-to-load-jpa-entities-more-selectively-in-n1-scenarios/
 
 