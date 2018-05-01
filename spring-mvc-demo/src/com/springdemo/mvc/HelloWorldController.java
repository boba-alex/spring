package com.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// need a controller meth to show initial html form	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//contr meth to process the html Form
	@RequestMapping("/processForm")
	private String processForm() {
		return "helloworld";
	}
	
	// new method to read form data
	// add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String processData(HttpServletRequest request, Model model) {
		
		//read request parameter
		String theName = request.getParameter("studentName");
		
		//convert
		theName = theName.toUpperCase();
		
		//create message
		String result = "Yo! " + theName;
		
		//add to the model attribute
		model.addAttribute("message", result);
		
		return "helloworld";		
	}
	
	// @RequestParam!
	@RequestMapping("/processFormVersionThree")
	public String processData1(@RequestParam("studentName") String theName, Model model) {
		
		//convert
		theName = theName.toUpperCase();
		
		//create message
		String result = "Hey Request Param " + theName;
		
		//add to the model attribute
		model.addAttribute("message", result);
		
		return "helloworld";		
	}
	
}
