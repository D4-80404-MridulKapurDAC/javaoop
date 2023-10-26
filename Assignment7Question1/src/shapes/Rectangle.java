package shapes;

public class Rectangle extends Polygon {
	double length;
	double breadth;
	
	@Override
	public double calcArea() {
		return length*breadth;
	}

	public Rectangle(int x, int y, int number_of_sides, double length, double breadth) {
		super(x, y, number_of_sides);
		this.length = length;
		this.breadth = breadth;
	}
	
	
}
