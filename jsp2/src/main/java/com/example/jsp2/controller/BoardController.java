package com.example.jsp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	@GetMapping("/index")
	public String index() {
		
//		prefix: /WEB-INF/views/
//	    suffix: .jsp
//		/WEB-INF/views/index.jsp
		return "index";
	}
	
	@GetMapping("/example1")
	public String example1() {
		return "example1";
	}
}
