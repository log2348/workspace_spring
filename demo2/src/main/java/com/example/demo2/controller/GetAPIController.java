package com.example.demo2.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.dto.UserRequest;

@RestController
@RequestMapping("/api/get")
public class GetAPIController {

	@GetMapping("pratice")
	public String getWordPratice() {
		return "주소 맵핑 방식 연습";
	}
	
	// path-variable 방식
	@GetMapping(path = "/my-path-variable/{productName}/{count}")
	public String queryParam(@PathVariable(name = "productName") String productName,
			@PathVariable(name = "count") int count) {

		String prodName = productName;
		int prodCount = count;
		
		return "productName : " + prodName + ", count + " + prodCount;
	}
	
	// query parameter 방식 1. 키 값을 지정해서 값을 받는 방식
	// query parameter -> 메소드에 선언하지 않은 변수 넣어도 받을 수 있다
	@GetMapping("query-param1")
	public String queryParam1(@RequestParam String productName,
			@RequestParam int count) {
		return "productName : " + productName + ", count : " + count;
	}
	
	// query parameter 방식 2. Map 활용 방식
	// 스프링 부트 사용하면 스트림 달지 않아도 어노테이션들이 자동으로 처리해줌
	@GetMapping("query-param2")
	public String queryParam2(@RequestParam Map<String, String> data) {
		
		StringBuffer sb = new StringBuffer();
		
		data.entrySet().forEach(entry -> {
			sb.append(entry.getKey() + "=" + entry.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	// query parameter 방식 3. Dto 활용 방식 (어노테이션 사용 x)
	@GetMapping("query-param3")
	public String queryParam3(UserRequest request) {
		return request.toString();
	}
	
}
