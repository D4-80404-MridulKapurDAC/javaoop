package shapes;

public class Square extends Polygon{
	double side;
	@Override
	public double calcArea() {
		return side*side;
	}
	public Square(int x, int y, double side) {
		super(x, y, 4);
		this.side = side;
	}
	
	
}
