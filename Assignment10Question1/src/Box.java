
public class Box <T extends Employee>{
	private T emp;
	public Box(T emp) {
		this.emp = emp;
	}
	public void calcSal() {
		System.out.println(emp.calcSalary());
	}
}
