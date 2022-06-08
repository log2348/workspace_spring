package adapter2;

public class MyHairDryer implements IElectronic220v {

	@Override
	public void connect() {
		System.out.println("헤어 드라이기 연결 ! 220v On");		
	}

}
