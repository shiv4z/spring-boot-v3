package in.shiv;

public class DiselEngine implements IEngine{
	
	public DiselEngine() {
		System.out.println("DiselEngine :: Constructor");
	}

	@Override
	public int start() {
		System.out.println("Engine started...");
		return 1;
	}

}
