package am.itspace.taskmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping ("/")

    public String mainPage(){
        System.out.println("Hello from controller");
        return "index";
    }
}
