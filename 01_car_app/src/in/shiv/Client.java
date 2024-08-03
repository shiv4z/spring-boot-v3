package in.shiv;

public class Client {
	public static void main(String[] args) {
	//	PetrolEngine petrolEngine = new PetrolEngine();
	//	DiselEngine diselEngine = new DiselEngine();
		Car car = new Car(new DiselEngine());
		car.setEng(new PetrolEngine());
		car.drive();
	}

}
