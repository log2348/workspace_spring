package com.example.demo4_1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo4_1.dto.User;

@RestController
@RequestMapping("/api3")
public class APIController {
	
	// DELETE
	@DeleteMapping("/delete/{userId}")
	public void delete(@PathVariable String userId, @RequestParam String account) {
		System.out.println("userId : " + userId);
		System.out.println("account : " + account);
	}
	
	//MIME TYPE
	
	// plain/text
	@GetMapping("/text")
	public String text(@RequestParam String account) {
		return account;
	}
	
	@PutMapping("/put")
	public ResponseEntity<?> put(@RequestBody User user) {
		// 응답할 때 응답코드 지정해서 보낼 수 있는 객체
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	// PUT
	@PutMapping("put/{userId}")
	public User put(@RequestBody User requestDto,
			@PathVariable(name = "userId") Long id) {
		System.out.println("userId : " + id);
		return requestDto;
	}
	
	

}
