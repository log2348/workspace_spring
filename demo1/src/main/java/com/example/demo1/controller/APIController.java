package com.example.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Controller - 주소를 만들어주는 역할

@RestController
@RequestMapping("/api/get")
public class APIController {	
	/*
	 * URL : 자원을 요청하는 주소 체계 방식
	 * URI : 식별자 방식
	 */

	// http://localhost:9090/api/get/hello
	@GetMapping("/hello")
	public String getHello() {
		return "sayHello";
	}
	
	// path-variable 방식
	
	// get -> URI 방식 사용 (데이터를 담아서 요청 -> 요청 받아서 처리 -> 응답)
	// http://localhost:9090/api/get/path-variable/[xxx] // 일반적으로 언더바(_)보다 하이픈(-)을 더 많이 씀	
	@GetMapping(path = "/path-variable/{name}")
	public String queryParam(@PathVariable(name = "name") String name) {	
		
		System.out.println("브라우저에서 들어온 값을 받음 : " + name);
		return "[[" + name + "]]";
	}
	
	// http://localhost:9090/api/get/path-variable/[xxx]/[xxx]
	@GetMapping(path = "/path-variable/{name}/{age}")
	public String queryParam2(@PathVariable(name = "name") String name,
			@PathVariable(name = "age") int age) {
		
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		return "name : " + name + ", " + "age : " + age;
	}
	
	// 문제 1 : 새로운 주소 만들어서 요청하고 응답받기 (인자값 하나)
	@GetMapping(path = "/path-variable1/{message}")
	public String queryParam3(@PathVariable(name = "message") String message) {
		
		System.out.println("message : " + message);
		return "message : " + message;
	}
	
	// 문제 1 : 새로운 주소 만들어서 요청하고 응답받기 (인자값 두개)
	@GetMapping(path = "/path-variable1/{id}/{message}")
	public String queryParam4(@PathVariable(name = "id") int id,
			@PathVariable(name = "message") String message) {
		
		System.out.println("id : " + id);
		System.out.println("message : " + message);
		return "id : " + id + ", " + "message : " + message;
	}
	
	// 메서드 오버로딩 가능
	
}
