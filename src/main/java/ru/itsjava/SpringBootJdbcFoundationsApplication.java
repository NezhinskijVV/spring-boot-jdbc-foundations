package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itsjava.dao.StudentDao;
import ru.itsjava.domain.Student;

import java.sql.SQLException;


@SpringBootApplication
public class SpringBootJdbcFoundationsApplication {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(SpringBootJdbcFoundationsApplication.class, args);

       // Console.main(args);

        StudentDao studentDao = context.getBean(StudentDao.class);
        System.out.println("studentDao.count() = " + studentDao.count());

        Student student = new Student("San", 33);
        studentDao.insert(student);

        System.out.println("studentDao.count() = " + studentDao.count());


        Student updatedStudent = new Student("Ivanov 2", 100);
        updatedStudent.setId(1L);
        studentDao.updateStudent(updatedStudent);

        studentDao.delete(updatedStudent);
        System.out.println("studentDao.count() = " + studentDao.count());

        Console.main(args);
    }

}
