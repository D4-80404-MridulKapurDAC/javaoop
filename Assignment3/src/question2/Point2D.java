package question2;

import java.lang.Math;

public class Point2D {
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String getDetails() {
		return Integer.toString(this.x) + "," + Integer.toString(this.y);
	}
	
	
	public boolean isEqual(Point2D cmp) {
		if(this.x != cmp.getX() || this.y != cmp.getY()) {
			return false;
		}
		return true;
	}
	
	public double distance(Point2D dest) {
		return Math.sqrt(Math.pow(this.x-dest.getX(),2) + Math.pow(this.y-dest.getY(),2));
	}
}