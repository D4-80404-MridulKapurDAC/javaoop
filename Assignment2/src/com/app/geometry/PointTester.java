package com.app.geometry;

import java.util.Scanner;

public class PointTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inp1 , inp2;
		
		inp1 = sc.nextInt();
		inp2 = sc.nextInt();
		Point2D p1 = new Point2D(inp1,inp2);
		
		inp1 = sc.nextInt();
		inp2 = sc.nextInt();
		Point2D p2 = new Point2D(inp1,inp2);
		
		p1.getDetails();
		p2.getDetails();
		
		if(p1.isEqual(p2)) {
			System.out.println("Points are same");
		}
		else {
			System.out.println("Points are unequal");
			System.out.println(p1.distance(p2));
		}
	}

}
