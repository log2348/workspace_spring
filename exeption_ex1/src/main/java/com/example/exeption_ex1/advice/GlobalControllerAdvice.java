package com.example.exeption_ex1.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice // Global
// @RestControllerAdvice(basePackages = "com.example.exception_ex1.controller") // 특정 패키지에서만 동작
// @ControllerAdvice // 뷰 리졸브, data ( MessageConverter )
@RestControllerAdvice(basePackages = "com.example.exception_ex1.controller")
public class GlobalControllerAdvice {
	
	// 모든 예외가 발생하면 다 이 클래스 파일로 오게끔 -> advice
	// 모든 예외상황을 처리하고 싶을 때 사용
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {	
		System.out.println("==============================");
		System.out.println(e.getClass());
		System.out.println(e.getMessage());
		System.out.println("==============================");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}
	
	// 특정 예외 상황에서는 다른 응답 처리를 하고 싶을 때
	// MissingServletRequestParameterException
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e) {
		System.out.println("MissingServletRequestParameterException 동작 !!!");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		System.out.println("여기는 advice");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

}
