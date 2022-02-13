package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.dao.StudentDao;
import ru.itsjava.domain.Student;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentDao studentDao;

    @Override
    public void insert(Student student) {
        long id = studentDao.insert(student);
        System.out.println("ID нового студента = " + id);
    }
}
