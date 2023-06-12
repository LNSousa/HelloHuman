package com.lsousa.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/")
	public String greeting(@RequestParam(value="name", required=false) String firstName, @RequestParam(value="lname", required=false) String lastName, @RequestParam(value="times", required=false) int times) {
		String statement = "";
		
		if(times == 0) {
			times = 1;
		}
		if(firstName == null) {
			statement = "Hello human";
		} else if(lastName == null) {
			statement = "Hello " + firstName;
		} else {			
			statement = "Hello " + firstName + " " + lastName;
		}
		
		if(times > 1) {
			String multStatement = statement;
			for (int i = 1; i < times; i++) {
				multStatement = multStatement + " " + statement;
			}
			return multStatement;
		} else {
			return statement;
		}
	}
}
