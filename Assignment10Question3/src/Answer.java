interface Displayable {
	void display();
}

class Person implements Displayable {
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
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

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=").append(name).append(", age=").append(age).append("]");
		return builder.toString();
	}

	@Override
	public void display() {
		System.out.printf("Name: %s, Age: %d\n", this.name, this.age);
	}
}

class Book implements Displayable {
	private String name;
	private double price;
	public Book(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [name=").append(name).append(", price=").append(price).append("]");
		return builder.toString();
	}

	@Override
	public void display() {
		System.out.printf("Name: %s, Price: %.2f\n", this.name, this.price);
	}
}

class Car {
	private String name;
	private double price;
	public Car(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public void display() {
		System.out.printf("Name: %s, Price: %.2f\n", this.name, this.price);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [name=").append(name).append(", price=").append(price).append("]");
		return builder.toString();
	}
	
}

// bounded type parameter
class Box<T extends Displayable> {
	private T obj;
	public void set(T obj) {
		this.obj = obj;
	}
	public T get() {
		return this.obj;
	}
	public void show() {
		obj.display();
	}
}


public class Answer {
	
	public static void printDisplayableBox(Box b) {
		b.get().display();
	}
	
	public static void printAnyBox(Box b) {
			System.out.println(b.get().toString());
	}
	
	public static void main(String[] args) {
		Box<Person> b1 = new Box<>();
		b1.set(new Person("Nilesh", 40));
		b1.show();
		printAnyBox(b1);
		printDisplayableBox(b1);
		Box<Book> b2 = new Box<>();
		b2.set(new Book("Atlas Shrugged", 763.39));
		b2.show();
//		printAnyBox(b2);
//		printDisplayableBox(b2);
		
//		Box<Car> b3 = new Box<>(); // compiler error
		
		//Box<String> b4 = new Box<>(); // compiler error
		
	}
}






