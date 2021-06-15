package spring_project.notlockeduser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring_project.notlockeduser.DAO.PersonDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {
    PersonDAO people;

    @Autowired
    PeopleController (PersonDAO people){
        this.people = people;
    }

    @GetMapping("/all")
    public String getIndex (Model model){
        model.addAttribute("people" ,people.getIndex());
        return "people/allPeople";
    }

    @GetMapping("/{id}")
    public String getOnId (@PathVariable("id") int id, Model model){
        model.addAttribute(people.getPerson(id));
        return "people/showId";
    }
}
