
class B extends A{
	public int y;
	@Override
	public Integer m1() {
		return new Integer(6);
	}
}

public class Test {
	
//	public void fn()int 
	
	public static void main(String args[]) {
		B b  = new B();
		b.x = 10;
//		b.y = 11;
//		b.m1();
		
	}
	
}

//class Testing2 extends Testing{
//	public static void display() {
//		System.out.println();
//	}
//}
