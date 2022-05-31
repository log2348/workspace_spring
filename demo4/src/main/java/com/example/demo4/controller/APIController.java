package com.example.demo4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo4.dto.User;

@RestController
@RequestMapping("/api")
public class APIController {
	
	// MIME TYPE 이해하기
	// 정확하게 어떤 걸 보내겠다, 받겠다 해야 원하는 대로 응답처리 할 수 있다.
	
	// text/plain <--- content Type : text/plain
	@GetMapping("/text")
	public String text(@RequestParam String account) {
		return account;
	}
	
	// application/json
	// request --> MessageConverter라는 녀석이 Object Mapping을 해준다 --> Object --> Method
	@PostMapping("/json")
	public User json(@RequestBody User user) {
		System.out.println(user.getName());
		return user;
	}	
	
	@PutMapping("/put")
	public ResponseEntity<?> put(@RequestBody User user) {
		// ResponseEntity<?> : 202, 200 -> 응답을 돌려줄 때 응답코드를 지정해서 보낼 수 있다.
		// ResponseEntity를 통해서 status, header 등을 설정할 수 있다.
		return ResponseEntity.status(HttpStatus.OK).body(user); // HttpStatus.CREATED - Insert 성공했을 때 201번
	}
}
