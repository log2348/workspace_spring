package observer;

public class MainTest {
	
	public static void main(String[] args) {
		
		Button button = new Button("My Button");
		button.setiButtonListener(event -> {
			System.out.println("main에서 동작 넘겨 받은 메시지 : " + event);
		});
		
		button.click("클릭1");
		button.click("클릭2");
		button.click("클릭3");

	}
}
