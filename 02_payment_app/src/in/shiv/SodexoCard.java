package in.shiv;

public class SodexoCard implements IPayment{

	public SodexoCard() {
		System.out.println("SodexoCard :: Constructor");
	}
	
	@Override
	public boolean pay(double amount) {
		System.out.println("SodecoCard payment...");
		return false;
	}

}
