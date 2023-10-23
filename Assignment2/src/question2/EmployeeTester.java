package question2;

public class EmployeeTester {
	public static void main(String[] args) {
		Employee e1 = new Employee("fname", "lname", 123);
		Employee e2 = new Employee("fname2","lname2",1234);
		e1.setSalary(e1.getSalary()*1.1);
		e2.setSalary(e2.getSalary()*1.1);
		System.out.println(e1.getSalary());
		System.out.println(e2.getSalary());
	}
}
