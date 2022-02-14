package ru.itsjava.dao;

import ru.itsjava.domain.Faculty;

import java.util.List;

public interface FacultyDao {

    List<Faculty> findAll();

    Faculty findByName(String name);
}
