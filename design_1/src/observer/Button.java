package observer;

// 호출자 역할
public class Button {
	
	private String name;
	private IButtonListener iButtonListener;
	
	// 2가지 방법 (생성자로 연결, 메서드로 연결하는 방법(setter))
	// Button btn = new Button();
	// btn.setiButtonListener(this); 익명 클래스 처리 (콜백 받는 클래스에서 처리)
	public Button(String name) {
		this.name = name;
	}

	public void setiButtonListener(IButtonListener iButtonListener) {
		this.iButtonListener = iButtonListener;
	}

	public void click(String message) {
		iButtonListener.clickEvent(message);
	}

}
