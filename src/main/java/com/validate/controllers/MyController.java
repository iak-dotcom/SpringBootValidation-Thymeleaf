package com.validate.controllers;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.validate.entities.LoginData;


@Controller
public class MyController {
	@GetMapping("/form")
	public String openForm(Model model) {
		System.out.println("Opening form");
		model.addAttribute("loginData", new LoginData());
		return "form";
	}
	//Handler for processing form
	
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData")LoginData loginData, BindingResult bindingResult) {
			
			if(bindingResult.hasErrors()) {
			System.out.println("inside has error");
			return "form";
		}else {
		
		System.out.println(loginData);
		return "success";
	}
}
}