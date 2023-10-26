package shapes;

public class Triangle extends Polygon{
	int side1;
	int side2;
	int side3;
	@Override
	public double calcArea() {
		double s = (side1+side2+side3)/2;
		return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
	}
	public Triangle(int x, int y, int side1, int side2, int side3) {
		super(x, y, 3);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	
}
