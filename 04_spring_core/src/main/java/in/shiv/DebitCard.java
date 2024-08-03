package in.shiv;

public class DebitCard implements IPayment{

	public DebitCard() {
		System.out.println("DebitCard :: Constructor");
	}
	public boolean pay(double amount) {
		System.out.println("Payment processing...");
		return true;
	}

}
