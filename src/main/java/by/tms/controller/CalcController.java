package by.tms.controller;

import by.tms.dao.hibernate.OperationDaoHibernate;
import by.tms.dao.hibernate.UserDaoHibernate;
import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CalcController {

    @Autowired
    private OperationDaoHibernate operationDaoHibernate;

    @Autowired
    private UserDaoHibernate userDaoHibernate;


    @GetMapping("/calc")
    public String calc(@ModelAttribute("operation") Operation operation) {
        return "calc/calc";
    }

    @PostMapping("/calc")
    public String calc(@ModelAttribute("operation") @Valid Operation operation, BindingResult bindingResult,
                       HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            return "calc/calc";
        }
        Double res = OperationService.getResultOperation(operation);
        model.addAttribute("result",res);
        operation.setResult(res);
        operationDaoHibernate.saveOperation(operation);
        User user = (User) session.getAttribute("user");
        List<Operation> operationList = user.getOperation();
        operationList.add(operation);
        user.setOperation(operationList);
        userDaoHibernate.save(user);
        return "calc/calc";
    }

    @GetMapping("/history")
    public String history(@ModelAttribute("operation") Operation operation, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        model.addAttribute("history", user.getOperation());
        return "user/history";
    }


}
