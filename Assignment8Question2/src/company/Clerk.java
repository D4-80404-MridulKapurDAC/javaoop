package company;

public class Clerk extends Employee {
		
	@Override
	public void accept() {
		super.accept();
	}
	
	@Override
	public double calcSalary() {
		return salary;
	}

	public Clerk() {
		super();
	}

	public Clerk(String name, int age, int salary, int id) {
		super(name, age, salary, id);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Clerk)) {
			return false;
		}
		return true;
	}
	
	

}
