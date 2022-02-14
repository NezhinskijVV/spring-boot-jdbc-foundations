package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itsjava.services.AppService;



@SpringBootApplication
public class SpringBootJdbcFoundationsApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootJdbcFoundationsApplication.class, args);
        context.getBean(AppService.class).start();
    }

}
