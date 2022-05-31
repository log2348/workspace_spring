# DELETE 방식에 이해 및 실습 

학습목표 

1. @ DeleteMapping 이해 
2. @PathVariable 사용 
3. @RequestParam 사용 



![img](https://blog.kakaocdn.net/dn/dg4uby/btru3sFVT8k/CgWF1BYOCIvOc6Dnabbzq1/img.png)



```java

@RestController
@RequestMapping("/api2")
public class DeleteApiController {
	
	@DeleteMapping("/delete/{userId}")
	public void delete(@PathVariable String userId, @RequestParam String account) {
		
		System.out.println("userId : " + userId);
		System.out.println("account : " + account);
	}
	
}

```



