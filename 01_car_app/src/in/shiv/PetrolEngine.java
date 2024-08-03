package in.shiv;

public class PetrolEngine implements IEngine{

	public PetrolEngine() {
		System.out.println("PetrolEngine :: Constructor");
	}

	@Override
	public int start() {
		System.out.println("Engine started...");
		return 1;
	}
}
