package question2;

import question2.Point2D;
import java.util.Scanner;

public class TestPointArray1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of points : ");
		Point2D[] points = new Point2D[sc.nextInt()];
		for(int i = 0;i<points.length;i++) {
			System.out.println("Enter x : ");
			int x = sc.nextInt();
			System.out.println("Enter y : ");
			int y = sc.nextInt();
			points[i] = new Point2D(x,y);
		}
		int choice = -1;
		while(true) {
			System.out.println("1.Display specific point \n2.Display all points\n3.Display distance\nEnter choice :");
			choice =  sc.nextInt();
			if(choice == 1){
				System.out.println("Enter index : ");
				int idx = sc.nextInt();
				if(idx >= points.length){
					System.out.println("Invalid index , pls retry!!!!");
				}else {
					System.out.println(points[idx].getDetails());
				}
			}else if(choice == 2) {
				for(Point2D point : points) {
					System.out.println(point.getDetails());	
				}
			}
			else if(choice == 3) {
				int idx1 = sc.nextInt();
				int idx2 = sc.nextInt();
				if(idx1 >= points.length || idx2>=points.length) {
					System.out.println("Invalid index");
				}
				else if(points[idx1].isEqual(points[idx2])) {
					System.out.println("Equal");
				}else {					
					System.out.println("Distance : " + points[idx1].distance(points[idx2]));
				}
			}
			else {
				break;
			}
		}
	}

}
