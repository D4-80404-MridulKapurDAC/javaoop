import java.util.Scanner;
public class Question1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number : ");
		int x = sc.nextInt();
		System.out.println("Your Number : " + x);
		System.out.println("Binary : " + Integer.toBinaryString(x));
		System.out.println("Hex : " + Integer.toHexString(x));
		System.out.println("Octal : " + Integer.toOctalString(x));
	}

}
