package company;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee cnt : ");
		int empcnt = sc.nextInt();
		Employee[] mployees = new Employee[empcnt];
		for(int i = 0 ; i < mployees.length;i++) {
			System.out.println("1.Lab 2.clerk 3.Sales");
			int ch = sc.nextInt();
			if(ch == 1) {
				mployees[i] = new Labor("L2" ,123,1,4,5,6);
			}else if(ch == 2) {
				mployees[i] = new Clerk("C1",1234,12,23);
			}else {
				mployees[i] = new Salesman("S3",1234,123,21,3,78);
			}
			try{
				mployees[i].accept();
			}catch(EmployeeException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		for(Employee e:mployees) {
			System.out.println(e.toString());
		}
		
		System.out.println("Clerks : " + Employees.averageSalClerks(mployees));
		System.out.println("Labor : " + Employees.averageSalLabor(mployees));
		System.out.println("Salesmanager : " + Employees.averageSalSalesman(mployees));
	}

}
