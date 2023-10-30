package company;

import java.util.Objects;
import java.util.Scanner;

public abstract class Person {
	String name;
	int age;
	
	public void accept() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name : ");
		this.setName(sc.next());
		System.out.println("Enter age : ");
		this.setAge(sc.nextInt());
	}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Person() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age){
		if(age<=0) {
			throw new EmployeeException("Age",age);
		}
		this.age = age;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return super.toString() + String.format("Person [name=%s, age=%s]", name, age);
	}
	
	
}
