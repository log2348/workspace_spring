Validation 에 이해 및 실습 

학습 목표 

1. Validation에 대한 이해 
2. 어노테이션 사용 하는 방법 
3. bindingResult 사용 하는 방법 



Validation 이란 프로그래밍에 있어서 가장 필요한 부분중에 하나 입니다. 

특히 자바에서는 null 값에 대해서 접근 하려고 할 때 null pointException 이 발생 하기 때문에 이러한 부분을 방지 하기 위해서 미리 검증하는 과정을 Validation 이라고 한다. 



* 검증해야 할 값이 많은 경우 코드의 길이가 길어 진다. 
* 구현에 따라서 달라 질 수 있지만 핵심기능과 분리가 필요하다. 





라이브러리 필요 

```java
implementation 'org.springframework.boot:spring-boot-starter-validation'
```



```

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation1.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {
    //post 방식 처리에 대한 @Valid 확인 (반드시 @Valid 지정해 주어야 한다)
	@PostMapping("/user")
	public ResponseEntity<?> user(@Valid @RequestBody User user, BindingResult bindingResult) {

		// 예전 방식
		if (user.getAge() < 1 || user.getAge() > 110) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}

		// 에러가 발생시에 custom 해서 프론트 개발자가 잘 처리할 수 있도록 설계 해야 한다.
		// BindingResult 가 @Valid 대한 결과값을 가지고 있다.
		if (bindingResult.hasErrors()) {
			// 에러가 있다면 여기서 처리
			StringBuilder sb = new StringBuilder();
			bindingResult.getAllErrors().forEach(error -> {
				FieldError field = (FieldError) error;
				String message = field.getDefaultMessage();
				System.out.println("field : " + field.getField());
				System.out.println("message : " + message);
				sb.append("field : " + field.getField() + "\n");
				sb.append("message : " + message + "\n");
			});
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}

		System.out.println(user);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

}
```



```java

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * 
 * 
 * {
 * 	  "name" : "홍길동", 
 *    "age" : 0, 
 *    "email" : "a@naver.com", 
 *    "phoneNumber" : "010-1234-1234"
 *  
 * }
 * 
 *
 */

public class User {
	
	@NotBlank(message = "이름을 입력해주세요")
	private String name;
	@Max(value = 90, message = "나이를 잘못 입력했습니다")
	@Min(value = 10, message = "나이를 잘못 입력했습니다.")
	private int age;
	
	@Email
	private String email;
	
	private String phoneNumber;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	} 
	
	
}
```



