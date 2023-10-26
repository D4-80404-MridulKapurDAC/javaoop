package shapes;

public abstract class Polygon extends BoundedShape{
	int number_of_sides;

	public Polygon(int x, int y, int number_of_sides) {
		super(x, y);
		this.number_of_sides = number_of_sides;
	}

}
