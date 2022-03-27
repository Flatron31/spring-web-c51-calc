package by.tms.controller;

import by.tms.dao.OperationDaoHibernate;
import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private OperationDaoHibernate operationDaoHibernate;

    @GetMapping()
    public String calc(@ModelAttribute("operation") Operation operation) {
        return "calc";
    }

    @PostMapping
    public String calc(@ModelAttribute("operation") @Valid Operation operation, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "calc";
        }
        Double res = OperationService.getResultOperation(operation);
        model.addAttribute("result",res);
        operation.setResult(res);
        operationDaoHibernate.saveOperation(operation);
        return "calc";
    }

    @GetMapping("/history")
    public String history(@ModelAttribute("user") User user){
        return "user/history";
    }
    @PostMapping("/history")
    public String history(@ModelAttribute("user") User user, Model model){
        model.addAttribute("user", user.getOperation());
        return "user/history";
    }

}
