package ru.itsjava.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JdbcTest
@Import(StudentDaoImpl.class)
public class StudentJdbcDaoImplTest {
    private static final String DEFAULT_NAME = "Ivanov 2";
    private static final int DEFAULT_AGE = 100;
    private static final long FIRST_ID = 1L;
    private static final long NEW_ID = 3L;

    @Autowired
    private StudentDao studentDao;


    @Test
    public void shouldHaveCorrectCount() {
        int actualStudentsCount = studentDao.count();

        assertEquals(2, actualStudentsCount);
    }

    @Test
    public void shouldHaveCorrectInsert() {
        Student expectedStudent = new Student(NEW_ID, DEFAULT_NAME, DEFAULT_AGE);
        studentDao.insert(expectedStudent);
        Student actualStudent = studentDao.findById(NEW_ID);

        assertEquals(actualStudent, expectedStudent);
    }

    @Test
    public void shouldHaveCorrectUpdate(){
        Student expectedStudent = new Student(FIRST_ID, DEFAULT_NAME, DEFAULT_AGE);
        studentDao.update(expectedStudent);
        Student actualStudent = studentDao.findById(FIRST_ID);

        assertEquals(actualStudent, expectedStudent);
    }

    @Test
    public void shouldHaveCorrectDelete(){
        Student deletedStudent = studentDao.findById(FIRST_ID);
        studentDao.delete(deletedStudent);

        assertEquals(studentDao.count(), 1);
    }

}