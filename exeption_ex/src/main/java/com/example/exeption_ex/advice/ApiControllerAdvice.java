package com.example.exeption_ex.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exeption_ex.dto.CustomError;

@RestControllerAdvice
public class ApiControllerAdvice {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		
		System.out.println("==================================================");
		System.out.println("예외 발생 !!");
		System.out.println("Class Name : " + e.getClass());
		System.out.println("Message : " + e.getMessage());
		System.out.println("==================================================");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}
	
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e) {
		// GET 방식일 때 에러
		String errorField = e.getParameterName();
		String errorMessage = e.getMessage();
		
		System.out.println("==============================================================");
		System.out.println("MissingServletRequestParameterException 발생 !!!");		
		System.out.println(errorMessage);
		System.out.println("==============================================================");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorField + " 필드에 오류가 존재합니다.");
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		// POST 방식일 때 에러
		System.out.println("MethodArgumentNotValidException 발생 !!");
		
		List<CustomError> errorList = new ArrayList<>();
		BindingResult bindingResult = e.getBindingResult();
		
		bindingResult.getAllErrors().forEach(action -> {
			FieldError fieldError = (FieldError) action;
			
			String fieldName = fieldError.getField();
			String message = fieldError.getDefaultMessage();
			
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setMessage(message);
			errorList.add(customError);
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
	

}
