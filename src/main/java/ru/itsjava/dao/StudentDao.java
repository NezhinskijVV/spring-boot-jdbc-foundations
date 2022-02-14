package ru.itsjava.dao;

import ru.itsjava.domain.Student;

import java.util.List;

public interface StudentDao {

    int count();

    long insert(Student student);

    void update(Student student);

    void delete(Student student);

    Student findById(long id);

    List<Student> findAll();
}
