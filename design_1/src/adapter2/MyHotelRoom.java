package adapter2;

public class MyHotelRoom {
	
	public static void hotelConnect(IElectronic110v iElectronic110v) {
		iElectronic110v.connect();
	}

	public static void main(String[] args) {
		MyLaptop laptop = new MyLaptop();
		MyCleaner cleaner = new MyCleaner();
		MyHairDryer hairDryer = new MyHairDryer();
		
		hotelConnect(cleaner);
		
		// hotelConnect(laptop);
		// hotelConnect(hairDryer);
			
		MyElectronicAdapter adapter1 = new MyElectronicAdapter(laptop);
		hotelConnect(adapter1);
		
		MyElectronicAdapter adapter2 = new MyElectronicAdapter(hairDryer);
		hotelConnect(adapter2);

	}

}
