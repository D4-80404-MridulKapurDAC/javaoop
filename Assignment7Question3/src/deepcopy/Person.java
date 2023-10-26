package deepcopy;

public class Person implements Cloneable{
	String name;
	int height;
	Date birth;
	
	
	public Person(String name, int height, Date birth) {
		super();
		this.name = name;
		this.height = height;
		this.birth = birth;
	}

	public void display() {
		System.out.println(name+" "+height+ " ");
		birth.display();
	}
	
	
	public Date getBirth() {
		return birth;
	}

	

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public void setName(String n) {
		this.name = n;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Person p = ((Person)super.clone());
		p.setBirth((Date)p.getBirth().clone());
		return p;
	}
}
