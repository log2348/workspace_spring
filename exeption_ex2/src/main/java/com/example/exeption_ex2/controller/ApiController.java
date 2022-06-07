package com.example.exeption_ex2.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exeption_ex2.dto.User;

@RestController
@RequestMapping("/api")
@Validated // GET 방식일 때 Validation 적용
public class ApiController {

	@GetMapping("/user")
	public User user(@Size(min=2, max=20) @RequestParam(required = true) String name,
			@NotNull
			@Min(1)
			@RequestParam(required = true) Integer age) {
		
		int mAge = age + 10;

		User user = new User();
		user.setName(name);
		user.setAge(mAge);
		
		return user;
	}
	
	// 컴파일러가 매핑방식을 구분하기 때문에 주소가 달라도 오류 x
	@PostMapping("/user")
	public User user(@Valid @RequestBody User user) { // 메서드 오버로딩
		return user;
	}

}
