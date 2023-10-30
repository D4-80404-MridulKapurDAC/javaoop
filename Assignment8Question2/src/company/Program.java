package company;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee cnt : ");
		int empcnt = sc.nextInt();
		Employee[] mployees = new Employee[empcnt];
		for(int i = 0 ;i<mployees.length;i++) {
			System.out.println("1.Lab 2.clerk 3.Sales");
			int ch = sc.nextInt();
			if(ch == 1) {
				mployees[i]= new Labor();
			}else if(ch == 2) {
				mployees[i] = new Clerk();
			}else {
				mployees[i] = new Salesman();
			}
			try{
				mployees[i].accept();
			}catch(EmployeeException ex) {
				System.out.println(ex.getMessage());
			}
		}
		System.out.println("Clerks : " + Employees.averageSalClerks(mployees));
		System.out.println("Labor : " + Employees.averageSalLabor(mployees));
		System.out.println("Salesmanager : " + Employees.averageSalSalesman(mployees));
	}

}
