package company;

public class Employees {
	public static double averageSalSalesman(Employee[] arr) {
		double total = 0;
		int count = 0;
		for(Employee e : arr) {
			if(e instanceof Salesman){
				count++;
				total+=(e.calcSalary());
			}
		}
		return total/count;
	}
	public static double averageSalLabor(Employee[] arr) {
		double total = 0;
		int count = 0;
		for(Employee e : arr) {
			if(e instanceof Labor){
				count++;
				total+=(e.calcSalary());
			}
		}
		return total/count;
	}
	public static double averageSalClerks(Employee[] arr) {
		double total = 0;
		int count = 0;
		for(Employee e : arr) {
			if(e instanceof Clerk){
				count++;
				total+=(e.calcSalary());
			}
		}
		return total/count;
	}
}
