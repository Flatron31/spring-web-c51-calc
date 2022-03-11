package by.tms.controller;

import by.tms.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/reg")
	public String reg(@ModelAttribute("newUser") User user, Model model) {
		return "reg";
	}

	@PostMapping("/reg")
	// результат должен быть после валидируемой модели

	public String reg(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasGlobalErrors()) {
//			Map<String, String> map = new HashMap<>();
			for (FieldError fieldError: bindingResult.getFieldErrors()) {
				model.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());
//				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
//		model.addAllAttributes(map);
			return "reg";
		}

		System.out.println(bindingResult.hasErrors());
		model.addAttribute("myName", user.getName());
		model.addAttribute("myPassword", user.getPassword());


		return "test";
	}
}