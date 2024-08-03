package in.shiv;

public class PaymentService {
	
	public PaymentService() {
		System.out.println("PaymentService :: Constructor");
	}
	private IPayment pay;
	
	public void pay(double billAmount) {
		boolean status = pay.pay(billAmount);
		if(status) {
			System.out.println("Payment success...");
		}else {
			System.out.println("Payment failure...");
		}
	}
	

}
