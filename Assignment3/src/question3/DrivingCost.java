package question3;

import java.util.Scanner;

public class DrivingCost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double totalMilesPerDay  = sc.nextDouble();
		double costPerGallon = sc.nextDouble();
		double avgMilesPerGallon = sc.nextDouble();
		double parking = sc.nextDouble();
		double tolls = sc.nextDouble();
		System.out.println(costPerGallon * totalMilesPerDay / avgMilesPerGallon + parking + tolls);
		
	}

}
