package spring_project.notlockeduser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/h")
    public String getHomePage(){
        return "hello_world";
    }
}
