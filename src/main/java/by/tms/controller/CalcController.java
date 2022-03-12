package by.tms.controller;

import by.tms.entity.Operation;
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
    public String calc(@ModelAttribute("operation") Operation operation){
        return "calc";
    }

    @PostMapping
    public String calc(@ModelAttribute("operation") @Valid Operation operation, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "calc";
        }

        Double result = 0.0;
        Double value1 = operation.getValue1();
        Double value2 = operation.getValue2();
        String operation1 = operation.getOperation();
        switch (operation1){
            case "sum":
                result = value1 + value2;
                break;
            case "dif":
                result = value1 - value2;
                break;
            case "mult":
                result = value1 * value2;
                break;
            case "div":
                result = value1 / value2;
                break;
            }
            model.addAttribute("result", result);
        return "calc";
    }
}
