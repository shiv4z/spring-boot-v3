package in.shiv;

public class DebitCard implements IPayment{

	public DebitCard() {
		System.out.println("DebitCard :: Constructor");
	}
	@Override
	public boolean pay(double amount) {
		System.out.println("DebitCard payment ...");
		return false;
	}

}
