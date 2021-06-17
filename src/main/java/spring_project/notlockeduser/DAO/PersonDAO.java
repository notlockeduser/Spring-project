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
        listPeople.add(new Person(ID++, "Bob", "t@mail", 27));
        listPeople.add(new Person(ID++, "Tob", "twr@mail", 23));
        listPeople.add(new Person(ID++, "Billy","321@mail", 22));
        listPeople.add(new Person(ID++, "Ugly", "adfa@mail", 28));
    }

    public List<Person> getIndex() {
        return listPeople;
    }

    public Person getPerson(int id) {
        System.out.println(listPeople.get(id));
        return listPeople.get(id);
    }

    public void add(Person person) {
        person.setId(ID++);
        listPeople.add(person);
    }

    public void update(Person person, int id) {
        listPeople.get(id).setName(person.getName());
        listPeople.get(id).setEmail(person.getEmail());
        listPeople.get(id).setAge(person.getAge());
    }

    public void delete(int id) {
        listPeople.remove(id);
    }
}
