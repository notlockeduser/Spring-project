package spring_project.notlockeduser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring_project.notlockeduser.DAO.PersonDAO;
import spring_project.notlockeduser.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {
    PersonDAO people;

    @Autowired
    PeopleController (PersonDAO people){
        this.people = people;
    }

    @GetMapping("")
    public String getIndex (Model model){
        model.addAttribute("people" ,people.getIndex());
        return "people/allPeople";
    }

    @GetMapping("/{id}")
    public String getOnId (@PathVariable("id") int id, Model model){
        model.addAttribute(people.getPerson(id));
        return "people/showId";
    }

    @GetMapping("/new")
    public String newPerson (Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    public String savePerson (@ModelAttribute Person person){
        people.add(person);
        return "redirect:/people";
    }
}
