package pkg;
//import A;

public class Child extends Parent{
	int c;
	
	public Child(int gp, int p,int c) {
		super(gp, p);
		this.c = c;
		// TODO Auto-generated constructor stub
	}

	public void ch() {
		System.out.println("child");
	}
	
	@Override
	public void over() {
		System.out.println("over child");
	}
}
