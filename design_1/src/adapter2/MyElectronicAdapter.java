package adapter2;

public class MyElectronicAdapter implements IElectronic110v {
	
	private IElectronic220v iElectronic220v;
	
	public MyElectronicAdapter(IElectronic220v iElectronic220v) {
		this.iElectronic220v = iElectronic220v;
	}

	@Override
	public void connect() {
		iElectronic220v.connect();		
	}

}
