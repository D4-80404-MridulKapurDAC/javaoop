

import java.util.Objects;
import java.util.Scanner;

public class Labor extends Employee {
	int rate;
	int hours;
	
	@Override
	public void accept() {
		super.accept();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter rate : ");
		this.setRate(sc.nextInt());
		System.out.println("Enter hours : ");
		this.setHours(sc.nextInt());
	}
	
	@Override
	public double calcSalary() {
		return rate*hours;
	}
	
	public Labor(String name, int age, int salary, int id, int rate, int hours) {
		super(name, age, salary, id);
		this.rate = rate;
		this.hours = hours;
	}
	
	public Labor() {
		super();
	}
	
	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		if(rate <= 0)
			throw new EmployeeException("Rate", rate);
		this.rate = rate;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		if(hours <= 0 ) {
			throw new EmployeeException("Hours", hours);
		}
		this.hours = hours;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(hours, rate);
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
		if (!(obj instanceof Labor)) {
			return false;
		}
		Labor other = (Labor) obj;
		return hours == other.hours && rate == other.rate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("Labor [rate=").append(rate).append(", hours=").append(hours).append("]");
		return builder.toString();
	}
	
	
	
}
