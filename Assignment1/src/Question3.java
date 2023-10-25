import java.util.Scanner;

public class Question3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {1,2,3,4,5};
		int choice = -1;
		int bill = 0;
		while(true) {
			System.out.println("1.Idli\n2.Vada\n3.Dosa\n4.Medu Vada\n5.Sambhar\n10.Bill");
			choice =  sc.nextInt();
			if(choice >= 1 && choice<=4){
				bill += arr[choice];
			}else if(choice == 10) {
				System.out.println("Total bill = "+bill+" rupees");
			}
		}
	}
}