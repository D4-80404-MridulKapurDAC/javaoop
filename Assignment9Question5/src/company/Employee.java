package company;

import java.util.Objects;
import java.util.Scanner;

public abstract class Employee extends Person {
	int salary;
	int id;
	
	@Override
	public void accept(){
		super.accept();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Sal : ");
		this.setSalary(sc.nextInt());
		System.out.println("Enter ID : ");
		this.setId(sc.nextInt());
	}
	
	public Employee(String name, int age, int salary, int id) {
		super(name, age);
		this.salary = salary;
		this.id = id;
	}
	public Employee() {
		super();
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		if(salary <= 0) {
			throw new EmployeeException("Salary" , salary);
		}
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public abstract double calcSalary();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id, salary);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		return id == other.id && salary == other.salary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("Employee [salary=").append(salary).append(", id=").append(id).append("]");
		return builder.toString();
	}
	
	
}
