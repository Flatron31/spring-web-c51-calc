package by.tms.controller;

import by.tms.entity.Calc;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calc")
public class CalcController {

    @GetMapping()
    public String calc(){
        return "calc";
    }

    @PostMapping
    public String reg(Calc calc, Model model) {
        double result = 0.0;
        double value1 = calc.getValue1();
        double value2 = calc.getValue2();
        String operation = calc.getOperation();
        switch (operation){
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
