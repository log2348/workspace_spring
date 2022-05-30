package com.example.demo_2.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_2.dto.UserRequest;

@RestController
@RequestMapping("/api2")
public class PostAPIController {
	
	/**
	 * {
	 * 		"name" : "value"
	 * 		"age" : value
	 * }
	 *  
	 */

	// 1. 맵 방식 ( @RequestBody )
	// http://localhost:9090/api2/post1 (POST)
	@PostMapping("/post1")
	public String post1(@RequestBody Map<String, Object> requestData) {
		System.out.println("post test1");
		StringBuffer sb = new StringBuffer();

		requestData.entrySet().forEach(entry -> {
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
			sb.append(entry.getKey() + "=" + entry.getValue());
		});
		
		return sb.toString(); // 응답시 보여지는 값
	}
	
	// 2. Dto 방식	
	@PostMapping("/post2")
	public String post2(@RequestBody UserRequest requestData) {
		System.out.println(requestData.toString() + "데이터가 잘 들어옴 !!!");
		return requestData.toString();
	}
	
	/*
	 * java/mobile 생각해보면
	 * 네트워크 통신에서 br,bw가 문자열을 전송할 때
	 * 코드상에서 json parsing을 해야한다
	 * 그러나 스프링에서는, 파싱 과정 없이도 문자열이 자동으로 Object가 된다.
	 * 메세지 컨버터라는 녀석이 자동으로 문자열 파싱해서 UserRequest(Dto)가 맵핑 처리 해준다.
	 */
	
}
