package spring_project.notlockeduser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/home")
    public String getHomePage(){
        return "main/home";
    }

    @GetMapping("/about")
    public String getAboutPage(){
        return "main/about";
    }
}
