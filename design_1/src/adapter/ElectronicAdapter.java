package adapter;

// 220v
public class ElectronicAdapter implements IElectronic220v{

	// adapter 패턴을 설계하는 방법
	
	// 1. 포함관계를 만들어준다. Electronic110v
	private IElectronic110v electronic110v;
	
	// 2. 생성자를 통해서 의존 주입을 받을 수 있도록 설계한다.
	// 생성자는 객체를 메모리에 올릴 때 반드시 호출해야 하는 강제성을 갖는다
	public ElectronicAdapter(IElectronic110v electronic110v) {
		this.electronic110v = electronic110v;
	}

	@Override
	public void connect() {
		// 런타입 시점에 올라가있는 객체의 동작을 호출한다.
		// null x -> 어댑터 객체 생성할 때 무조건 생성되기 때문에
		electronic110v.connect();
	}
	
}
