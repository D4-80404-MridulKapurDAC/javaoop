package pkg;
//import A;

public class Child extends Parent{
	int c;
	
	private static class c1{
		int x = 2;
	}
	
	private static class c2{
		c1 obj = new c1();
		int y = obj.x;
	}
	
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
