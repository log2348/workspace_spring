package com.example.exeption_ex.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exeption_ex.dto.Student;

@RestController
@RequestMapping("/api/jh")
@Validated // GET 방식 Validation 처리법 ! 이 어노테이션 달아주고 메서드 필드에 Validation 처리
public class ApiController {
	
	@GetMapping("/student")
	public Student get(@NotNull @RequestParam String name,
			@NotNull
			@RequestParam String major,
			@Min(1)
			@RequestParam Integer studentNumber) {
		Student student = new Student();
		student.setName(name);
		student.setMajor(major);
		student.setStudentNumber(studentNumber);
		
		return student;
	}
	
	@GetMapping(path = "/student/{name}")
	public String get(@PathVariable(name = "name") String name) {
		Student student = new Student();
		student.setName(name);
		
		return student.getName();
	}
	
	@PostMapping("/student")
	public Student post(@Valid @RequestBody Student student) {
		return student;
	}
	

}
