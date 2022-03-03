package by.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {

	@GetMapping
	public String test(@RequestParam(required = false, defaultValue = "Guest") String name,
										 @RequestParam(required = false) int age, Model model) { //localhost:8080/test GET
		model.addAttribute("myName", name);
		model.addAttribute("myAge", age);
		return "test"; // /pages/test.jsp
	}

	@GetMapping("/hello/{name}/{age}") //localhost:8080/hello/denis/22
	public String hello(@PathVariable String name,
											@PathVariable int age) { //localhost:8080/test/hello GET
		return "hello";
	}
}
