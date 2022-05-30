POST 방식에 이해 및 실습 



학습 목표 

JSON 이해 

POST 주소 맵핑

@RequestBody 에 대한 이해와 Map 구조로 값 받아 보기 

@Dto 를 사용해서 처리해 보기 



![img](https://blog.kakaocdn.net/dn/bh1LEa/btruWQ7R2Kv/BolbYs2BMXL7rkXqIlqBR1/img.png)



```java

@RestController
@RequestMapping("/api2")
public class PostApiController {
	
	/**
	 *  {
	 *  	"name" : "value"
	 *  	"age" : value 
	 *      "birth : value" 
	 *  }
	 */
	// 1. MAP 방식 ( @RequestBody ) 
	// http://localhost:9090/api2/post1 (POST) 
	@PostMapping("/post1")
	public String post1(@RequestBody Map<String, Object> requestData) {
		System.out.println("post1 test1");
		StringBuffer sb = new StringBuffer(); 
		requestData.entrySet().forEach(entry -> {
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
			sb.append(entry.getKey() + "=" + entry.getValue());
		});
		
		return sb.toString(); 
	}
	
	
	// 2. dto 방식 
	// java / mobile 
	// 네이트워크 통신 BR, BW ---> 문자열 전송 ( json parsing )
	// why 문자열이 자동으로 Object가 되는가 !!! 
	// 메세지 컨버터 라는 녀석이 자동으로 문자열 파싱해서 --> UserRequest 맵핑 처리 
	@PostMapping("/post2")
	public String post2(@RequestBody UserRequest requestData) {
		System.out.println(requestData.toString() + "데이터가 잘 들어 옴 !!!! ");
		return requestData.toString(); 
	}
	
}

```



