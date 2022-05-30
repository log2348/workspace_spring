package com.example.demoex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@GetMapping("/user") // GET 방식
	public String user() {
		
		return "hello String";
	}
	
	@GetMapping("/home")
	public String home() {
		
		String temp = "{\r\n"
				+ "	\"name\" : \"홍길동\"\r\n"
				+ "}";
		return temp;
	}
	
}
