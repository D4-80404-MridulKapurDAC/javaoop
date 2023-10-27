package shop;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Product products[] = new Product[5];
		System.out.println("Enter number of products : ");
		int prods=sc.nextInt();
		for(int i = 0 ; i < prods;i++) {
			System.out.print("1.Book\n2.Album\n3.Toy\nEnter type of product ");
			int ch = sc.nextInt();
			if(ch == 1) {
				products[i] = new Book();
				products[i].setDetails();
			}else if(ch == 2) {
				products[i] = new Album();
				products[i].setDetails();	
			}else if(ch == 3) {
				products[i] = new Toy();
				products[i].setDetails();
			}
			else {
				System.out.println("Invalid choice.Enter again.");
				i--;
			}
		}
		double totalRevenue = 0;
		double totalBill = 0;
		for(Product p : products) {
			if(p == null)break;
			totalRevenue += p.getRevenue();
			totalBill += p.getSellprice();
			System.out.println(p.getTitle() + " : " + p.getPrice());
		}
		System.out.println("Total bill : "+totalBill);
		System.out.println("Total revenue : "+totalRevenue);
		sc.close();
	}

}
