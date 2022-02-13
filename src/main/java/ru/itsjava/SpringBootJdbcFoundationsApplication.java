package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itsjava.domain.Faculty;
import ru.itsjava.domain.Student;
import ru.itsjava.services.StudentService;

import java.sql.SQLException;


@SpringBootApplication
public class SpringBootJdbcFoundationsApplication {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(SpringBootJdbcFoundationsApplication.class, args);
       context.getBean(StudentService.class).insert(new Student("uskov", 15,  new Faculty(1L, "Android Development")));

        Console.main(args);
    }

}
