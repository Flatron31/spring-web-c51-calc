package by.tms.controller;

import by.tms.dao.UserDaoHibernate;
import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class UserController {

	@Autowired
	private UserDaoHibernate userDAOHibernate;

	private static long idUserCOUNT;

	@GetMapping
	public String home() {
		if (userDAOHibernate.findById(1) == null) {
			userDAOHibernate.save(new User(++idUserCOUNT,"test1", "test1"));
			userDAOHibernate.save(new User(++idUserCOUNT,"test2", "test2"));
			userDAOHibernate.save(new User(++idUserCOUNT,"test3", "test3"));
			userDAOHibernate.save(new User(++idUserCOUNT,"test4", "test4"));
			userDAOHibernate.save(new User(++idUserCOUNT,"test5", "test5"));
		}
		return "user/index";
	}

	@GetMapping("/reg")
	public String reg(@ModelAttribute("user") User user) {
		return "user/reg";
	}

	@PostMapping("/reg")
	public String reg(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()){
			return "user/reg";
		}
		userDAOHibernate.save(user);
		return "redirect:/";
	}

	@GetMapping("/login")
	public String login(@ModelAttribute("user") User user){
		return "user/login";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
						HttpSession session, Model model){
		if (bindingResult.hasErrors()){
			return "user/login";
		}
		User userFromDB = new User();

		if (userDAOHibernate.findByUsername(user.getName()) != null) {
			userFromDB = userDAOHibernate.findByUsername(user.getName());
			if (userFromDB.getPassword().equals(user.getPassword())) {
				session.setAttribute("user", userFromDB);
			}
		} else {
			model.addAttribute("messageError", "User exist");
			return "user/login";
		}
		return "user/index";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session){
		if (session.getAttribute("user") == null){
			return "redirect:/";
		} else {
			session.invalidate();
		}
		return "redirect:/";
	}

	@GetMapping("/profile")
	public String index(Model model){
		model.addAttribute("users", userDAOHibernate.findAll());
		return "user/index1";
	}
	@GetMapping("/{id}")
	public String show(@PathVariable("id") int id, Model model){
		model.addAttribute("user", userDAOHibernate.findById(id));
		return "user/show";
	}






}