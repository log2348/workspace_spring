package com.example.demo3.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
public class DeleteAPIController {
	// DELETE - BODY 존재하지 않음
	
	// Path Variable, QueryParam 방식 함께 사용
	@DeleteMapping("/delete/{userId}")
	public void delete(@PathVariable String userId, @RequestParam String account) {
		System.out.println("userId : " + userId);
		System.out.println("account : " + account);	
	}
	
}
