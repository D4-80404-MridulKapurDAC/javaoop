package pkg;

public class Parent extends GrandParent{
	int p;
	
	public Parent(int gp, int p) {
		super(gp);
		this.p = p;
	}

	public void p(){
		System.out.println("Parent");
	}
	@Override
	public void over() {
		System.out.println("over P");
	}
}
