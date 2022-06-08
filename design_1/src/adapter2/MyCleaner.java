package adapter2;

public class MyCleaner implements IElectronic110v {

	@Override
	public void connect() {
		System.out.println("청소기 연결 ! 110v On");
		
	}

}
