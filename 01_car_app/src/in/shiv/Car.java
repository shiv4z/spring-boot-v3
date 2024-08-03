package in.shiv;

public class Car {

	private IEngine eng;

	public Car() {
		System.out.println("Car class Constructor :: Execution");
	}

	public Car(IEngine eng) {
		this.eng = eng;
	}

	public void setEng(IEngine eng) {
		this.eng = eng;
	}

	public void drive() {
		int start = eng.start();
		if (start > 0) {
			System.out.println("Car drive successfully...");
		} else {
			System.out.println("Engine failure occured...");
		}
	}

}
