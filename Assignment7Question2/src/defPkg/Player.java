package defPkg;

import java.util.Scanner;

abstract public class Player {
	int id;
	String name;
	int age;
	int matchesPlayed;
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Player))
			return false;
		Player p1 = (Player)obj;
		return this.id == p1.id;
	}
	
	public void accept() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter data : ");
		id = sc.nextInt();
		name = sc.next();
		age = sc.nextInt();
		matchesPlayed = sc.nextInt();
	}
	
}
