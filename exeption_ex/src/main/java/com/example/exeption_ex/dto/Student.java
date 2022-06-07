package com.example.exeption_ex.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Student {
	
	@NotNull
	@Min(1)
	private Integer studentNumber;
	
	@NotNull
	@Size(min=2, max=20)
	private String name;
	
	@NotNull
	private String major;

}
