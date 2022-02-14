package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Faculty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class FacultyDaoImpl implements FacultyDao{
    private final NamedParameterJdbcOperations jdbc;


    @Override
    public List<Faculty> findAll() {
        return jdbc.query("select id, name from faculties", new FacultyMapper());
    }

    @Override
    public Faculty findByName(String name) {
        return jdbc.queryForObject("select id, name from faculties where name = :name",
                new MapSqlParameterSource(Map.of("name", name)), new FacultyMapper());
    }

    private static class FacultyMapper implements RowMapper<Faculty> {

        @Override
        public Faculty mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Faculty(rs.getLong("id"), rs.getString("name"));
        }
    }
}
