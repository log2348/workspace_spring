package deco;

public class Audi implements ICar {

	private int modelPrice;
	
	public Audi(int modelPrice) {
		this.modelPrice = modelPrice;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return modelPrice;
	}

	@Override
	public void showPrice() {
		System.out.println("가격은 " + modelPrice + "만원입니다.");
		
	}
	
}
