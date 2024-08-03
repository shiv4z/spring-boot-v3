package in.shiv;

public class PaymentService {
	
	private IPayment pay;
	
	public PaymentService() {
		
	}
	public PaymentService(IPayment pay) {
		this.pay = pay;
	}

	public void setPay(IPayment pay) {
		this.pay = pay ;
	}
	
	public void payment(double amount) {
		boolean status = pay.pay(amount);
		if(status) {
			System.out.println("Payment is completed ::"+amount);
		}else {
			System.out.println("Payment failure ...");
		}
	}
}
