package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@SuppressWarnings("ALL")
@Repository
@RequiredArgsConstructor
public class StudentDaoImpl implements StudentDao {
    private final NamedParameterJdbcOperations jdbc;

    @Override
    public int count() {
        return jdbc.getJdbcOperations().queryForObject("select count(*) from students", Integer.class);
    }

    @Override
    public void insert(Student student) {
        Map<String, Object> params = Map.of("fio", student.getFio(), "age", student.getAge());
        jdbc.update("insert into students(fio, age) values (:fio, :age)", params);
    }

    @Override
    public void update(Student student) {
        Map<String, Object> params = Map.of("id", student.getId(), "fio", student.getFio(), "age", student.getAge());

        jdbc.update("update students set fio = :fio where id = :id", params);
        jdbc.update("update students set age = :age where id = :id", params);
    }

    @Override
    public void delete(Student student) {
        Map<String, Object> params = Map.of("id", student.getId());
        jdbc.update("delete from students where id = :id", params);
    }

    @Override
    public Student findById(long id) {
        Map<String, Object> params = Map.of("id", id);
        return jdbc.queryForObject("select id, fio, age from students where id = :id", params, new StudentsMapper());
    }


    private static class StudentsMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Student(rs.getLong("id"), rs.getString("fio"), rs.getInt("age"));
        }
    }


}
