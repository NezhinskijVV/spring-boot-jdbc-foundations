package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Student;

@SuppressWarnings("ALL")
@Repository
@RequiredArgsConstructor
public class StudentDaoImpl implements StudentDao {
    private final JdbcOperations jdbc;

    @Override
    public int count() {
        return jdbc.queryForObject("select count(*) from students", Integer.class);
    }

    @Override
    public void insert(Student student) {
        jdbc.update("insert into students(fio, age) values (?, ?)", student.getFio(), student.getAge());
    }

    @Override
    public void updateStudent(Student student) {
        jdbc.update("update students set fio = ? where id =?", student.getFio(), student.getId());
        jdbc.update("update students set age = ? where id =?", student.getAge(), student.getId());
    }

    @Override
    public void delete(Student student) {
        jdbc.update("delete from students where id = ?", student.getId());
    }
}
