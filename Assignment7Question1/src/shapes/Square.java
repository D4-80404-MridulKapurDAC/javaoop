package shapes;

public class Square extends Polygon{
	double side;
	@Override
	public double calcArea() {
		return side*side;
	}
}
