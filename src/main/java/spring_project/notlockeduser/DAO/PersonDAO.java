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
    static int ID = 0;
    //List<Person> listPeople = new ArrayList<>();

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
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String SQLRequest = "SELECT * FROM person";
            ResultSet resultSet = statement.executeQuery(SQLRequest);

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
//        System.out.println(listPeople.get(id));
//        return listPeople.get(id);
        return null;
    }

    public void add(Person person) {
//        person.setId(ID++);
//        listPeople.add(person);
    }

    public void update(Person person, int id) {
//        listPeople.get(id).setName(person.getName());
//        listPeople.get(id).setEmail(person.getEmail());
//        listPeople.get(id).setAge(person.getAge());
    }

    public void delete(int id) {
//        listPeople.remove(id);
    }
}
