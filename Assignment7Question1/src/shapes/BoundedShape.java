package shapes;

abstract public class BoundedShape {
	int x;
	int y;
	static public double PI = 3.14;
	abstract public double calcArea();
	public BoundedShape(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
