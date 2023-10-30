package q6;

import java.util.Scanner;

enum Menu{
	ACCEPT,FIND,PRINT,EXIT
}


public class A9Q6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pcnt = sc.nextInt();		
		Person[] p = new Person[pcnt];
		Menu ch  = Menu.ACCEPT;
		int curr = 0;
		while(ch != Menu.EXIT) {
			System.out.println("1.Accept,2.Find,3.Print,4.Exit");
			ch = Menu.values()[sc.nextInt() - 1];
			switch(ch) {
				case ACCEPT:{ 
					p[curr].accept();
					curr++;
					break;
				}
				case PRINT:{
					for(Person _p : p) {
						if(_p == null) {
							break;
						}
						_p.display();
					}
					break;
				}
				case FIND:{
					String toFind = sc.next();
					for(Person _p:p) {
						if(_p == null) {
							break;
						}
						if(_p.name.equals(toFind)) {
							_p.display();
						}
					}
					break;	
				}
				default:
					break;
			}
		}
	}
	}

}

public static void main(String[] args) {}}
		
}
