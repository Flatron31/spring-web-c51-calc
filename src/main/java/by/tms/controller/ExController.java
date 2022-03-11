package by.tms.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExController {

    @ExceptionHandler(RuntimeException.class)
    public String re (RuntimeException re, Model model){
        model.addAttribute("message","Some error");
        return "error";
    }
}
