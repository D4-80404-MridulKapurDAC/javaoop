package deepcopy;

public class Program {

	public static void main(String[] args) {
		Date b1 = new Date(1,2,3);
		Person p1 = new Person("name1" , 123,b1);
		Person p2  = null;
		try {
			p2 = (Person) p1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		p2.setName("YOOO");
		p1.getBirth().setDate(3,2,1);
		p1.display();
		p2.display();
	}

}
