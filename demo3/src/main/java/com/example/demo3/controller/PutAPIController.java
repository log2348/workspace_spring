package com.example.demo3.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.dto.PutRequestDto;

@RestController
@RequestMapping("/api")
public class PutAPIController {

	// 메소드 오버로딩
	
	@PutMapping("put/{userId}")
	public PutRequestDto put(@RequestBody PutRequestDto requestDto,
			@PathVariable(name = "userId") Long id) {
		System.out.println("userId : " + id);
		System.out.println(requestDto.toString());
		return requestDto;
	}
	
	@PutMapping("put")
	public PutRequestDto put(@RequestBody PutRequestDto requestDto) {
		System.out.println(requestDto.toString());
		return requestDto;
	}
}
