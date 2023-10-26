package shapes;

public class Circle extends BoundedShape {
	double radius;
	@Override
	public double calcArea() {
		return radius*radius*PI;
	}
	public Circle(int x, int y, double radius) {
		super(x, y);
		this.radius = radius;
	}
}
