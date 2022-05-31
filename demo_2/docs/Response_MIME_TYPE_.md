# Response 와 MIME TYPE에 이해 및 실습 





학습 목표 

1. MIME TYPE text/plain 에 이해 
2. MIME TYPE application/json 에 이해 
3. DTO 설계 및 요청과 응답 
4. ResponseEntity 개념과 custom 방법에 이해 





```java

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo4.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {

	// text/plain <-- contentType : text/plain
	@GetMapping("/text")
	public String text(@RequestParam String account) {
		return account;
	}

	// application/json
	@PostMapping("/json")
	// request --> Object Mapper --> object --> method
	public User json(@RequestBody User user) {
		System.out.println(user.getName());
		return user;
	}

	// 202, 200 -> 응답을 돌려 줄때 응답 코드를 지정해서 보낼 수 있다.
	@PutMapping("/put")
	public ResponseEntity<User> put(@RequestBody User user) {
		// ResponseEntity를 통해서 status, header 등을 설정할 수 있다.
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

}

```



```java

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * 
 * {
 * 	"name": "kkk", 
 *  "age" : 30, 
 *  "phone_number" : "010-1234-1234", 
 *  "address" : "부산시 해운대구 우동"
 * 	
 * }
 *
 */
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL) // null 값을 내려 주지 않고 싶을 때 사용한다. 
public class User {

	private String name; 
	private int age; 
	private String phoneNumber; 
	private String address;
	private String idNumber; 
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	} 
	
}
```

