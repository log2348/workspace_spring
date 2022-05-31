package com.example.demo3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CarDto {

	private String name;
	@JsonProperty("car_number")
	private String carNumber; // 던져오는 이름은 car_number이지만 나는 carNumber로 쓸거야

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carName) {
		this.carNumber = carName;
	}

	@Override
	public String toString() {
		return "CarDto [name=" + name + ", carNumber=" + carNumber + "]";
	}

}
