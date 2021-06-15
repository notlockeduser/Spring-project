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
    PersonDAO peopleDAO;

    @Autowired
    PeopleController(PersonDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @GetMapping("")
    public String getIndex(Model model) {
        model.addAttribute("people", peopleDAO.getIndex());
        return "people/allPeople";
    }

    @GetMapping("/{id}")
    public String getOnId(@PathVariable("id") int id, Model model) {
        model.addAttribute(peopleDAO.getPerson(id));
        return "people/showId";
    }

    @GetMapping("/new")
    public String getCreatePage(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @GetMapping("/{id}/edit")
    public String getEditPage(@PathVariable("id") int id, Model model) {
        model.addAttribute(peopleDAO.getPerson(id));
        return "people/edit";
    }

    @PostMapping()
    public String savePerson(@ModelAttribute Person person) {
        peopleDAO.add(person);
        return "redirect:/people";
    }

    @PostMapping("/{id}")
    public String updatePerson(@ModelAttribute Person person,
                               @PathVariable("id") int id) {
        peopleDAO.update(person, id);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        peopleDAO.delete(id);
        return "redirect:/people";
    }
}
