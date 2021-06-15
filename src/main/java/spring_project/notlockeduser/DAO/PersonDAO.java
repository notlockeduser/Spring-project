package spring_project.notlockeduser.DAO;

import org.springframework.stereotype.Component;
import spring_project.notlockeduser.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    static int ID = 0;
    List<Person> listPeople = new ArrayList<>();

    public PersonDAO() {
        listPeople.add(new Person(ID++, "Bob"));
        listPeople.add(new Person(ID++, "Tob"));
        listPeople.add(new Person(ID++, "Billy"));
        listPeople.add(new Person(ID++, "Ugly"));
    }

    public List<Person> getIndex() {
        return listPeople;
    }

    public Person getPerson(int id) {
        System.out.println(listPeople.get(id));
        return listPeople.get(id);
    }
}
