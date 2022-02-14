package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.dao.FacultyDao;
import ru.itsjava.domain.Faculty;
import ru.itsjava.domain.Student;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppServiceImpl implements AppService {
    private final StudentService studentService;
    private final IOService ioService;
    private final FacultyDao facultyDao;


    @Override
    public void start() {
        System.out.println("Добро пожаловать в наш Университет!");
        while (true) {
            System.out.println("Введите номер меню");
            System.out.println("1 -- напечать всех студентов, 2 - добавить студента, остальное выход");
            int menuNum = ioService.inputInt();

            if (menuNum == 1) {
                printAllStudents();
            } else if (menuNum == 2) {
                insertStudent();
            } else {
                System.exit(0);
            }
        }
    }

    @Override
    public void insertStudent() {
        System.out.println("Введите студента");
        System.out.println("Введите ФИО");
        String fio = ioService.input();
        System.out.println("Введите возраст");
        int age = ioService.inputInt();
        System.out.println("Введите факультет");
        String faculty = ioService.input();
        Faculty studentsFaculty = facultyDao.findByName(faculty);

        Student student = new Student(fio, age, studentsFaculty);
        studentService.insert(student);
    }

    public void printAllStudents() {
        List<Student> studentList = studentService.findAll();

        System.out.println("Список студентов" + studentList);
    }


}
