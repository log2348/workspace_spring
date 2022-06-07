package com.example.exeption_ex2.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		System.out.println("예외 발생");
		System.out.println("============================");
		System.out.println(e.getClass());
		System.out.println("============================");
		System.out.println(e.getMessage());
		System.out.println("============================");
		System.out.println(e.getCause()); // 왜 발생했는지
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}
	
	// GET 방식일 때 파라미터 없을 경우 발생
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(
			MissingServletRequestParameterException e) {
		System.out.println("MissingServletRequestParameterException 발생 !");
		
		String fieldName = e.getParameterName();
		String fieldType = e.getParameterType();
		String invalidValue = e.getMessage();
		
		// GET 방식일 때는 두 개 필드 다 안 적어도 하나만 에러로 처리
		
		System.out.println(fieldName);
		System.out.println(fieldType);
		System.out.println(invalidValue);	
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldName + "을 입력해야 합니다.");
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		System.out.println("MethodArgumentNotValidException 발생 !");
		
		// 한 번에 전부 들어온다.
		BindingResult bindingResult = e.getBindingResult();
		bindingResult.getAllErrors().forEach(action -> {
			// POST 방식일 때는 오류 난 부분 통으로 들어온다
			System.out.println("action : " + action.toString());
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
	}
}
