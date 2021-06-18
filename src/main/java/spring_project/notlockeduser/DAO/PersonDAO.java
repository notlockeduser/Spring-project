package spring_project.notlockeduser.DAO;

import org.postgresql.Driver;
import org.postgresql.jdbc.PgConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import spring_project.notlockeduser.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    static int ID = 4;
    JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getIndex() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person getPerson(int id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE id= ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void add(Person person) {
        jdbcTemplate.update("INSERT INTO person VALUES (1, ?,?,?)",
                person.getName(), person.getAge(), person.getEmail());

    }

    public void update(Person person, int id) {
        jdbcTemplate.update("UPDATE person SET name = ?, age = ?, email = ? WHERE id = ?",
                person.getName(), person.getAge(),  person.getEmail(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }
}
