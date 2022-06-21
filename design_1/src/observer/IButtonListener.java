package observer;

// 옵저버 패턴 구현하기
// 1. 인터페이스를 선언한다.

// 보일러 플레이트

@FunctionalInterface
public interface IButtonListener {
	void clickEvent(String event);
}
