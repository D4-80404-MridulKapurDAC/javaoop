package q6;

import java.util.Scanner;

enum Gender {
	MALE,FEMALE
}

public class Person {
	String name;
	int age;
	Gender gender;
	public void accept() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter name : ");
		this.name=sc.next();
		System.out.println("enter age : ");
		this.age=sc.nextInt();
		System.out.println("Enter gender : 1 Male, 2 Female");
		int ch = sc.nextInt();
		gender = Gender.values()[ch-1];
		
	}
	public void display() {
		System.out.println("Name : "+name );
		System.out.println("Age : "+age );
		System.out.println("Gender : "+gender);		
	}
}
