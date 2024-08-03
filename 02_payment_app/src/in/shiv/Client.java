package in.shiv;

public class Client {
	public static void main(String[] args) {
		PaymentService p = new PaymentService(new DebitCard());
		p.setPay(new SodexoCard());
		p.payment(1200.0);
	}

}
