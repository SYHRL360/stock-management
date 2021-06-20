package com.The360company.portfolio.inventorymanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.The360company.portfolio.inventorymanagement.entity.User;
import com.The360company.portfolio.inventorymanagement.service.UserService;
import com.The360company.portfolio.inventorymanagement.user.UserRegister;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserService userService;

	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/showRegistrationPage")
	public String showRegistrationPage(Model model) {
		
		model.addAttribute("userRegister", new UserRegister());
		
		return "registration-page";
	}
	
	@PostMapping("/processRegistration")
	public String processRegistration(
				@Valid @ModelAttribute("userRegister") UserRegister userRegister,
				BindingResult bindingResult,
				Model model,
				RedirectAttributes redirectAttribute) {
		
		// form validation
		if(bindingResult.hasErrors()) {
			return "registration-page";
		}
		
		String userName = userRegister.getUserName();
		
		// check the database if user already exists
		User existing = this.userService.findByUserName(userName);
		if(existing != null) {
			model.addAttribute("userRegister", new UserRegister());
			model.addAttribute("registrationError","User name sudah ada.");
		
			return "registration-page";
		}
		
		// create user account
		this.userService.save(userRegister);
		
		redirectAttribute.addFlashAttribute("registrationSuccess", "Registrasi berhasil, silahkan login");
		
		return "redirect:/showLoginPage";
	}
	
}
