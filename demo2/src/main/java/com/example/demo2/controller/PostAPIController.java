package com.example.demo2.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.dto.UserRequest;

@RestController
@RequestMapping("/api3")
public class PostAPIController {
	
	// POST - 요청할때마다 똑같은 결과값을 반환하지 않기 때문에 역등성 x
	
	// 1. 맵 방식
	@PostMapping("/post1")
	public String post1(@RequestBody Map<String, Object> requestData) {
		System.out.println("post1");
		StringBuffer sb = new StringBuffer();
		
		requestData.entrySet().forEach(entry -> {
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
			sb.append(entry.getKey() + "=" + entry.getValue());
		});
				
		return sb.toString();
	}
	
	@PostMapping("/post2")
	public String post2(@RequestBody UserRequest request) {
		System.out.println(request.toString() + " 데이터 잘 들어옴");
		return request.toString();
	}

}
