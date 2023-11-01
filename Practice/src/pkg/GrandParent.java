package pkg;

public class GrandParent {
	int gp;
	
	public GrandParent(int gp) {
		super();
		this.gp = gp;
	}

	public void gp(){
		System.out.println("GrandParent");
	}
	
	public void over() {
		System.out.println("over gp");
	}
}
