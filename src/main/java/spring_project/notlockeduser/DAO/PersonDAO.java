package spring_project.notlockeduser.DAO;

import org.postgresql.Driver;
import org.postgresql.jdbc.PgConnection;
import org.springframework.stereotype.Component;
import spring_project.notlockeduser.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    static int ID = 4;

    static String URL = "jdbc:postgresql://localhost:5432/firstDB";
    static String USERNAME = "postgres";
    static String PASSWORD = "postgre";

    static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> getIndex() {
        List<Person> people = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM person"
            );
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }

    public Person getPerson(int id) {
        Person person = new Person();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM person WHERE id= ?"
            );
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setAge(resultSet.getInt("age"));
            person.setEmail(resultSet.getString("email"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return person;
    }

    public void add(Person person) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO person VALUES (1, ?,?,?)"
            );

            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());
            statement.setString(3, person.getEmail());

            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(Person person, int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE person SET name = ?, age = ?, email = ? WHERE id = ?"
            );

            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());
            statement.setString(3, person.getEmail());
            statement.setInt(4, id);

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM Person WHERE id=?"
            );

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
