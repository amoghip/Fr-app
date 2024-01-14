package com.fr_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fr_app.Repository.UserRepository;
import com.fr_app.entity.User;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/showLoginPage")
	public String loginPage() {
		return "login/loginPage";
	}
	
	
	@RequestMapping("/showReg")
	public String showRegistration() {
		return "login/registration";
	}
	
	@RequestMapping("/saveReg")
	public String saveRegistration(@ModelAttribute("user")User user) {
		userRepo.save(user);
		return "login/loginPage";
	}
	 
	@RequestMapping("/verifyLogin")
	public String verifyRegistration( @RequestParam("emailId")String emailId,
			@RequestParam("password")String password, Model model ) {
		 User user = userRepo.findByEmail(emailId);
		 if(user!=null) {
			 if(user.getEmail().equals(emailId) && user.getPassword().equals(password)) {
					return "login/findfFlights";
				}else {
					model.addAttribute("error", "invalid email/password");
					return "login/loginPage";
				} 
		 }
		else {
			model.addAttribute("error", "invalid email/password");
			return "login/loginPage";
		}
	}
	
}
