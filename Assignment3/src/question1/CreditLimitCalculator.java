package question1;

import java.util.Scanner;

public class CreditLimitCalculator {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int accountNo;
		int pending;
		int totalCharged;
		int totalCredit;
		int allowedLimit;
		int totalCustomers;
		System.out.println("Number Of Customers : ");
		totalCustomers=sc.nextInt();
		for(int i = 0 ; i  < totalCustomers;i++) {
			System.out.print("Account = ");
			accountNo =  sc.nextInt();
			System.out.print("Allowed Credit = ");
			allowedLimit =  sc.nextInt();
			System.out.print("total items charged = ");
			totalCharged = sc.nextInt();
			System.out.print("total credit applied in this month = ");
			totalCredit = sc.nextInt();
			System.out.print("pending balance at the begining of the month = ");
			pending = sc.nextInt();
			System.out.print("new balance for next month = " + pending+" + "+totalCharged + " - " + totalCredit + " => " + (pending+totalCharged-totalCredit)) ;
			if(pending+totalCharged-totalCredit  < allowedLimit) {
				System.out.println("Allowed limit");
			}
			else {
				System.out.println("Allowed limit Exceeded");
			}
			System.out.println();
		}		
	}
}
