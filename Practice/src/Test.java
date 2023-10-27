
class A{
	public int x;
	public void m1() {
		if(this instanceof B) {
			B b = (B)this;			
			System.out.println(b.x);
		}
	}
}

class B extends A{
	public int y;
	@Override
	public void m1() {
		super.m1();
	}
}

public class Test {
	public static void main(String args[]) {
		A b  = new A();
		b.x = 10;
//		b.y = 11;
		b.m1();
		
	}
	
}

//class Testing2 extends Testing{
//	public static void display() {
//		System.out.println();
//	}
//}
