package in.shiv;

public class CreditCard implements IPayment{

	public CreditCard() {
		System.out.println("CreditCard :: COnstructor");
	}
	@Override
	public boolean pay(double amount) {
		System.out.println("CreditCard payment ....");
		return true;
	}

}
