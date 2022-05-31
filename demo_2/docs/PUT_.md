PUT 방식에 이해 및 실습 

학습 목표 

1. @PutMapping 이해 
2. Dto 안에 List<Object> 타입 만들어 보기 
3. 스네이크 케이스, 카멜 케이스 구분하기 
   1. @JsonProperty 속성에 대해 알아보자 
   2. @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
4. Path Variable 사용해 보기 



![img](https://blog.kakaocdn.net/dn/AQX89/btruW98QtDF/CFcorONHy3tlhGEBVVuHxK/img.png)





```java

@RestController
@RequestMapping("/api")
public class PutApiController {

	
	@PutMapping("/put/{userId}")
	public PutRequestDto put(@RequestBody PutRequestDto requestDto,
			@PathVariable(name = "userId") Long id) {
		System.out.println("userId : " + id);
		System.out.println(requestDto.toString());
		return requestDto;
	}
	
}
```





```java
{
  "name" : "아무거나",
  "age" : "110", 
  "car_list" : [
		{
			"name" : "A6", 
			"car_name" : "22너 3313"
		},
		{
			"name" : "R8", 
			"car_name" : "33너 1234"
		}	
	   ]
	
}
```





```java

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * @author ITPS
 *
 */
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PutRequestDto {

	private String name;
	private String age;
	// List
	private List<CarDto> carList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public List<CarDto> getCarList() {
		return carList;
	}

	public void setCarList(List<CarDto> carList) {
		this.carList = carList;
	}

	@Override
	public String toString() {
		return "PutRequestDto [name=" + name + ", age=" + age + ", carList=" + carList + "]";
	}

}
```





```java

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarDto {

	private String name;
	@JsonProperty("car_name")
	private String carName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	@Override
	public String toString() {
		return "CarDto [name=" + name + ", carName=" + carName + "]";
	}

}
```



