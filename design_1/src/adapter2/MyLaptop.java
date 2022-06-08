package adapter2;

public class MyLaptop implements IElectronic220v {

	@Override
	public void connect() {
		System.out.println("노트북 연결 ! 220v On");		
	}

}
