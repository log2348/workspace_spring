package proxy;

import java.util.concurrent.atomic.AtomicLong;

import aop.AopBrowser;

/**
 * 
 * @author Jihyeon
 *
 * Proxy는 대리인이라는 뜻으로, 뭔가를 대신해서 처리하는 것.
 * Proxy class를 통해서 대신 전달하는 형태로 설계되며, Client는 Proxy 클래스로부터 결과를 받는다.
 * Cache의 기능으로도 활용이 가능하다.
 * 즉, 한번 메모리에 로드된 것을 남겨뒀다가 다시 내려줄 수 있다.
 * Spring에서 많은 어노테이션을 활용하는데,
 * 이 프록시 패턴을 활용해서 aop를 구현할 수 있다. (관점지향 프로그래밍)
 * 
 */
public class MainTest {
	
	public static void main(String[] args) {
		
		/*
		Browser browser = new Browser("www.naver.com");
		browser.show();
		browser.show();
		browser.show();
		browser.show(); // 새로운 Object가 매번 생성된 상황
		*/
		
		/*
		BrowserProxy browserProxy = new BrowserProxy("www.naver.com");
		browserProxy.show();
		browserProxy.show();
		browserProxy.show();
		browserProxy.show(); // 메모리에 올라가있는 걸 가지고와서 동작 처리 (Cache) --> 하나의 객체이다.
		*/
		
		/*
		IBrowser browser = new AopBrowser("www.google.com", new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
					}
				}, new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
					}
				}); 
				*/
		
		// 동시성 문제
		AtomicLong start = new AtomicLong();
		AtomicLong end = new AtomicLong();
		
		// 객체 초기화
		IBrowser browser = new AopBrowser("www.naver.com",
				() -> {
					System.out.println("before");
					start.set(System.currentTimeMillis());
				},
				() -> {
					long now = System.currentTimeMillis();
					end.set(now - start.get()); // 총 소요 시간 뽑아낼 수 있다.
				}
		);
		
		browser.show();
		System.out.println("loading time : " + end.get());
		// 첫번째 호출 (소요시간 : 1505)
		
		browser.show();
		System.out.println("loading time : " + end.get());
		// 두번째 호출
		
		browser.show();
		System.out.println("loading time : " + end.get());
		// 세번째 호출
		
		// AOP 관점 지향
		// 실제적으로 aop를 활용하는 사례는 특정한 메서드가 있으면 그 메서드의 실행 시간을 확인 (캐시 기능 잘 먹히는지)
		// 일괄적인 request 정보, response 정보 남긴다고 할 때 코드에다가 개별적으로 작성하는 것이 아니고
		// 일괄적으로 특정 클래스, 특정 패키지에 있는 모든 메서드의 전 후에 기능을 넣을 수 있는 방법을 제공한다.
	}

}
