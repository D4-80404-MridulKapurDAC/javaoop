package shapes;

public class Rectangle extends Polygon {
	double length;
	double breadth;
	
	@Override
	public double calcArea() {
		return length*breadth;
	}
}
