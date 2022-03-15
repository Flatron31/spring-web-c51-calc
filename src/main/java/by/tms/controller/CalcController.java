package by.tms.controller;

import by.tms.entity.Operation;
import by.tms.service.OperationService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/calc")
public class CalcController {

    @GetMapping()
    public String calc(@ModelAttribute("operation") Operation operation) {
        return "calc";
    }

    @PostMapping
    public String calc(@ModelAttribute("operation") @Valid Operation operation, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "calc";
        }
        model.addAttribute("result", OperationService.getResultOperation(operation));
        return "calc";
    }
}
