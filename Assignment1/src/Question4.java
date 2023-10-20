import java.util.Scanner;

public class Question4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sz = sc.nextInt();
		int space = sz-1;
		for(int i = 0 ;i <sz;i++) {
			for(int j = 0;j<space;j++) {
				System.out.print(" ");
			}
			for(int j = 0;j<=i;j++) {
				System.out.print("* ");	
			}
			System.out.print("\n");
			space--;
		}
		System.out.print("\n\n\n");
		space = sz-1;
		for(int i = 0 ;i <2*sz;i++) {
			for(int j = 0;j<Math.abs(space);j++) {
				System.out.print(" ");
			}
			for(int j = 0;j<=Math.min(2*sz-i-2, i)*2;j++) {
				System.out.print("*");	
			}
			System.out.print("\n");
			space--;
		}
		System.out.print("\n\n\n");
		space = sz-1;
		for(int i = 0 ;i <sz;i++) {
			for(int j = 0;j<space;j++) {
				System.out.print(" ");
			}
			for(int j = 0;j<=i;j++) {
				System.out.print("*");	
			}
			System.out.print("\n");
			space--;
		}
	}

}
