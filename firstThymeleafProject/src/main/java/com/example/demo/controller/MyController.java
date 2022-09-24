package com.example.demo.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Login;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Controller
public class MyController {

	@RequestMapping(value="/about", method = RequestMethod.GET)
	public String about(Model model) {
		System.out.println("Inside About Handler..");
		model.addAttribute("Name", "Akhilesh Maurya");
		//	model.addAttribute("Age", "24");
		model.addAttribute("currentDate", new Date());
        return "about"; // execute about.html
	}
	//handling iteration

	@GetMapping("/method2")
	public String iterateHandler(Model m) {
	//	List<String> Name=List.of("Ramu","Kalu","Malu","abhishek");
	//	m.addAttribute("Name", "Name");
		return "iteration";
	}
	//handling Conditional Statment(ternary operator)

	@GetMapping("/method3")
	public String conditionalHandling(Model m1) {

		m1.addAttribute("isActive", false);
		m1.addAttribute("gender", "F");
		return "conditionHandling";
	}
	// Login Page Validation

	@GetMapping("/login")
	public String openForm(Model m2) {

		m2.addAttribute("loginData", new Login()); 
		return "login";

	}

	@PostMapping("/submit")
	public String get(@RequestParam("email") String email,@RequestParam("password") String password)
	{
		System.out.println(email);
		System.out.println(password);
		return "login";
	}

	
	  @GetMapping("/home")
	  public String homePage(Model m3) {
		  return "home";
	  }
	  
	  @GetMapping("/signUp")
	  public String signUp(Model m4) {
		  return "signUp";
	  }
	}

