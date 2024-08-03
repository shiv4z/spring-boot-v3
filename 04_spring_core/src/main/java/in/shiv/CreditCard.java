package in.shiv;

public class CreditCard implements IPayment{

	public CreditCard() {
		System.out.println("CreditCard :: Constructor");
	}
	public boolean pay(double amount) {
		System.out.println("Payment processing...");
		return true;
	}

}
