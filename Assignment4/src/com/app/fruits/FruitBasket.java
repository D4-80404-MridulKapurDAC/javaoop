package com.app.fruits;

import java.util.Scanner;

public class FruitBasket {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Fruit[] basket = new Fruit[n];
		int choice = -1;
		int counter = 0;
		choice = sc.nextInt();
		while(choice != 9) {			
			switch(choice) {
				case 1:{
					if(counter == n) {
						System.out.println("Basket Full .");
					}
					System.out.println("Name : ");
					String nm = sc.next();
					System.out.println("Weight : ");
					double weight = sc.nextDouble();
					System.out.println("Color : ");
					String color = sc.next();
					basket[counter++] = new Mango(nm,weight,color,true);
					break;
				}
				case 2:{
					if(counter == n) {
						System.out.println("Basket Full .");
					}
					System.out.println("Name : ");
					String nm = sc.next();
					System.out.println("Weight : ");
					double weight = sc.nextDouble();
					System.out.println("Color : ");
					String color = sc.next();
					basket[counter++] = new Apple(nm,weight,color,true);
					break;
				}
				case 3 :{
					if(counter == n) {
						System.out.println("Basket Full .");
					}
					System.out.println("Name : ");
					String nm = sc.next();
					System.out.println("Weight : ");
					double weight = sc.nextDouble();
					System.out.println("Color : ");
					String color = sc.next();
					basket[counter++] = new Orange(nm,weight,color,true);
					break;
				}
				case 4:{
					for(Fruit f : basket) {
						if(f != null) {
							f.getName();						
						}
					}
					break;
				}
				case 5:{
					for(Fruit f : basket) {
						if(f != null && f.isFresh) {
							f.getName();						
						}
					}	
					break;
				}
				case 6:{
					for(Fruit f : basket) {
						if(f != null && !f.isFresh) {
							f.getName();						
						}
					}
					break;
				}
				case 7:{
					int idx = sc.nextInt();
					if(basket[idx] != null)
					basket[idx].setFresh(false);
					break;
				}
				case 8:{
					for(Fruit f : basket) {
						if(f != null && f.taste() == "Sour")
							f.setFresh(false);	
					}
					break;
				}
			}
			choice = sc.nextInt();
		}
	}

}
