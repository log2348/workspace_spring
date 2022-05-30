package com.example.demo_2.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_2.dto.UserRequest;

@RestController
@RequestMapping("/api/get")
public class GetAPIController {
	
	// http://localhost:9090/api/get/hello
	@GetMapping("hello")
	public String getHello() {
		return "say Hello";
	}
	
	// path-variable 방식
	// http://localhost:9090/api/get/path-variable/[사용자가 보낸값]/[사용자가 보낸값]
	// 축약형
	@GetMapping(path = "/path-variable/{name}/{age}")
	public String queryParam(@PathVariable(name = "name") String name,
			@PathVariable(name = "age") int age) {
		
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		String myName = "[[" + name + "]]";
		String myAge = "[[" + age + "]]";
		
		return "name : " + myName + ", " + " age " + myAge;
	}
	
	// query parameter 방식 1 - 키 값을 지정해서 값을 받는 방식
	// http://localhost:9090/api/get/query-param1?name=홍길동&email=ten@naver.com&age=11
	@GetMapping("query-param1")
	public String queryParam1(@RequestParam String name,
			@RequestParam String email,
			@RequestParam int age) {
		return "name : " + name + ", email : " + email + ", age : " + age;
	}
	
	// query parameter 방식 2 - Map 활용 방식
	// 클라이언트 요청 Bw (전송) -> br (응답) -> 어노테이션들이 자동으로 처리 해주고 있음
	@GetMapping("query-param2")
	public String queryParam2(@RequestParam Map<String, String> data) {
		
		StringBuffer sb = new StringBuffer();
		
		data.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println();
			sb.append(entry.getKey() + "=" + entry.getValue() + "\n");
		});
		return sb.toString();
	}
	
	// query parameter 방식 3 - Dto 활용 방식
	// Dto 방식 -> 어노테이션 사용하지 않아도 됨
	@GetMapping("query-param3")
	public String queryParam3(UserRequest request) {
		
		return request.toString();
	}
}
