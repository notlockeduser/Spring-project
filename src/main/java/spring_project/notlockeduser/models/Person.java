package spring_project.notlockeduser.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    int id;
    @NotEmpty(message = "Name shouldn`t be empty")
    @Size(min = 1, max = 30, message = "Size of message from 0 to 30")
    String name;
    @NotEmpty(message = "Email shouldn`t be empty")
    @Email
    String email;
    @Min(value = 0, message = "Age should be 1+")
    int age;

    public Person() {
    }

    public Person(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
