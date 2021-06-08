package spring_project.notlockeduser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/home")
    public String getCalculatorPage() {

        return "main/home";
    }

    @GetMapping("/calculator")
    public String getCalculatorPage(Model model,
                                    @RequestParam(value = "num1", required = false) String num1,
                                    @RequestParam(value = "num2", required = false) String num2,
                                    @RequestParam(value = "oper", required = false) String operation) {

        String response = null;
        int number1, number2;
        if (num1 == null || num2 == null) {
            response = "Repeat your request";
        } else {
            number1 = Integer.parseInt(num1);
            number2 = Integer.parseInt(num2);
            switch (operation) {
                case "add":
                    response = number1 + " + " + number2 + " = " +
                            (number1 + number2);
                    break;
                case "sub":
                    response = number1 + " - " + number2 + " = " +
                            (number1 - number2);
                    break;
                case "div":
                    response = number1 + " / " + number2 + " = " +
                            (number1 / number2);
                    break;
                case "mul":
                    response = number1 + " * " + number2 + " = " +
                            (number1 * number2);
                    break;
                default:
                    response = "Repeat your request";
                    break;
            }
        }

        model.addAttribute("message", response);
        return "main/calculator";
    }

    @GetMapping("/about")
    public String getAboutPage() {
        return "main/about";
    }
}
