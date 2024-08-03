package in.shiv;

public class ElectricEngine implements IEngine{

	public ElectricEngine() {
		System.out.println("ElectricEngine :: Constructor");
	}

	@Override
	public int start() {
		System.out.println("Engine started...");
		return 1;
	}
}
