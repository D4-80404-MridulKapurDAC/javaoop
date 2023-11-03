import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student{
	int roll;
	String name;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [roll=").append(roll).append(", name=").append(name).append("]");
		return builder.toString();
	}
	
}

enum MENU{
	ADD,GET,GETALL,EXIT;
}

public class Answer {
	
	public static void acceptStudent(Student s) {
		Scanner sc = new Scanner(System.in);
		s.roll = sc.nextInt();
		s.name = sc.next();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MENU ch ;
		Map<Integer,Student> map = new HashMap<>();
		do {
			System.out.println("1.Add,2.Get,3.GetAll,4.Exit");
			ch = MENU.values()[sc.nextInt() - 1];
			switch(ch) {
				case ADD:
					Student temp = new Student();
					acceptStudent(temp);
					map.put(temp.roll, temp);
					break;
				case GET:
					int roll = sc.nextInt();
					Student curr = map.getOrDefault(roll,new Student());
					System.out.println(curr);
					break;
				case GETALL:
					System.out.println(map.toString());
					break;
				default:
					break;
			}
		}while(ch != MENU.EXIT);
		
	}

}
