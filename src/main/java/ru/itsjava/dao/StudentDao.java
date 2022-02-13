package ru.itsjava.dao;

import ru.itsjava.domain.Student;

public interface StudentDao {

    int count();

    void insert(Student student);

    void updateStudent(Student student);

    void delete(Student student);
}
