package by.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model ) {

//        System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message","Hello " + name + " " + surname);
        return "/hello";

    }

    @GetMapping("/goodbye")
    public String goodbye(){
        return "/goodbye";
    }
}
