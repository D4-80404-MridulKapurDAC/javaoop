import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

enum MENU{
	ADD,DELETE,FIND,SORT,EDIT,DISPLAY,EXIT
}

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		MENU ch;
		do {
			System.out.println("1ADD,2DELETE,3FIND,4SORT,5EDIT,6DISPLAY,7EXIT");
			ch = MENU.values()[sc.nextInt() -1];
			switch(ch) {
				case ADD:
					Employee e1 = new Employee();
					e1.accept();
					employeeList.add(e1);
					break;
				case DELETE:
					e1 = new Employee();
					e1.setId(sc.nextInt());
					employeeList.remove(e1);
				case FIND:
					e1 = new Employee();
					e1.setId(sc.nextInt());
					int idx = employeeList.indexOf(e1);
					if(idx == -1) {
						System.out.println("employee not found");
					}else {
						System.out.println(employeeList.get(idx));
					}
					break;
				case SORT:
					class SalCmp implements Comparator<Employee>{
						@Override
						public int compare(Employee arg0, Employee arg1) {
							return arg0.getSalary() - arg1.getSalary();
						}
					}
					employeeList.sort(new SalCmp());
					break;
				case EDIT:
					Employee key = new Employee();
					key.setId(sc.nextInt());
					int index = employeeList.indexOf(key);
					if(index == -1) {						
						System.out.println("Employee not found.");
					}else {
						Employee oldEmp = employeeList.get(index);
						System.out.println("Employee Found: " + oldEmp);
						System.out.println("Enter new information for the Employee");
						Employee newEmp = new Employee();
						newEmp.accept();
						employeeList.set(index, newEmp);
					}
					break;
				case DISPLAY:
					for(Employee e : employeeList) {
						System.out.println(e);
					}
					break;
				default:
					break;
					
			}
		}while(ch != MENU.EXIT);
	}

}
