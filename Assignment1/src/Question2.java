import java.util.Scanner;

public class Question2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Double num1,num2;
		if(sc.hasNextDouble()) {
			num1 = sc.nextDouble();			
		}
		else {
			System.out.println("not a number");
			return;
		}
		if(sc.hasNextDouble()) {
			num2 = sc.nextDouble();
		}
		else {
			System.out.println("not a number");
			return;
		}
		System.out.println((num1+num2)/2);
	}

}
