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
}
