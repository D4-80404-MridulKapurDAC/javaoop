package shapes;

public class Circle extends BoundedShape {
	double radius;
	@Override
	public double calcArea() {
		return radius*radius*PI;
	}

}
