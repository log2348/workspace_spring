package com.example.validation1.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation1.dto.User;

@RestController
@RequestMapping("/api")
@Validated // GET 방식일 때 처리, 안 붙이면 valid 처리 안됨
public class APIController {
	
	// get 방식일 때 Valid 처리하기
	// ?name=홍길동&age=10
	@GetMapping("/user")
	public User user(@Size(min = 2) @RequestParam String name,
			@NonNull @Min(1) @RequestParam Integer age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		return user;
	}

	// post 방식 처리에 대한 @Valid 확인 (반드시 Valid 지정해주어야 한다)
	@PostMapping("/user")
	public ResponseEntity<?> user(@Valid @RequestBody User user, BindingResult bindingResult) {

		// 예전 방식
		if (user.getAge() < 1 || user.getAge() > 110) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}

		// 에러가 발생시 custom 해서 프론트 개발자가 잘 처리할 수 있도록 설계해야 한다.
		// BindingResult가 @Valid에 대한 결과값을 가지고 있다.
		if (bindingResult.hasErrors()) {
			// 에러가 있다면 여기서 처리
			StringBuilder sb = new StringBuilder();
			bindingResult.getAllErrors().forEach(error -> {
				FieldError field = (FieldError) error;
				String message = field.getDefaultMessage();

				// 서버단에서 확인하는 코드
				System.out.println("field : " + field.getField());
				System.out.println("message : " + message);

				sb.append("field : " + field.getField() + "\n");
				sb.append("message : " + message + "\n");
			});

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}

		System.out.println(user);
		
		// 응답코드가 200이면 바디에 user dto 객체 넣어서 반환하는 것
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}
