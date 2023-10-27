package company;

import java.util.Objects;
import java.util.Scanner;

public class Salesman extends Employee {
	int target;
	int commission;
	
	@Override
	public void accept() {
		super.accept();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter target : ");
		this.setTarget(sc.nextInt());
		System.out.println("Enter commission : ");
		this.setCommission(sc.nextInt());
	}
	
	@Override
	public double calcSalary() {
		return salary+commission;
	}

	public Salesman(String name, int age, int salary, int id, int target, int commission) {
		super(name, age, salary, id);
		this.target = target;
		this.commission = commission;
	}

	public Salesman() {
		super();
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		if(target <= 0) {
			throw new EmployeeException("target", target);
		}
		this.target = target;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		if(commission <= 0) {
			throw new EmployeeException("Commission", commission);
		}
		this.commission = commission;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(commission, target);
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
		if (!(obj instanceof Salesman)) {
			return false;
		}
		Salesman other = (Salesman) obj;
		return commission == other.commission && target == other.target;
	}

}
