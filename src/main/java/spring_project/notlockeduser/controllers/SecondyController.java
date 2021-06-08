package spring_project.notlockeduser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondyController {
    @GetMapping("/exit")
    public String getHomePage(){
        return "secondly/exit";
    }

    @GetMapping("/settings")
    public String getAboutPage(){
        return "secondly/settings";
    }
}
