import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class program {
	public static void main(String[] args) {
		class CompDesc implements Comparator<Employee>{

			@Override
			public int compare(Employee arg0, Employee arg1) {
				return arg1.getSalary()-arg0.getSalary();
			}
			
		}
		Queue<Employee> pq = new PriorityQueue<Employee>(new CompDesc());
		Employee e1 = new Employee("name",123,1,2);
		pq.add(e1);
		e1 = new Employee("name1",13,14,23);
		pq.add(e1);
		e1 = new Employee("name2",13,15,22);
		pq.add(e1);
		e1 = new Employee("name3",23,11,21);
		pq.add(e1);
		e1 = new Employee("name4",3,12,24);
		pq.add(e1);
		while(!pq.isEmpty()) {
			System.out.println(pq.peek());
			pq.poll();
		}
	}
}
