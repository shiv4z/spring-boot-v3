package in.shiv;

public class CarService {
	
	private IEngine eng;
	
	public CarService() {
		System.out.println("CarService :: Constructor");
	}
	
	public CarService(IEngine eng) {
		this.eng = eng;
	}

	public void setEng(IEngine eng) {
		this.eng = eng;
	}
	public void drive() {
		int start = eng.start();
		if(start > 0) {
			System.out.println("Journey Started...");
		}else {
			System.out.println("Some Engine problem...");
		}
	}
}
