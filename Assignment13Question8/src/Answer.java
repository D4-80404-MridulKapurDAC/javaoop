/* Create an interface Emp with abstract method double getSal() 
 * and a default method default double calcIncentives().
 * The default method simply returns 0.0. 
 * Create a class Manager (with ﬁelds basicSalary and dearanceAllowance) inherited from Emp. 
 * In this class override getSal() method (basicSalary + dearanceAllowance) 
 * as well as calcIncentives() method (20% of basicSalary). 
 * Create another class Labor (with ﬁelds hours and rate) inherited from Emp interface. 
 * In this class override getSal() method (hours * rate) 
 * as well as calcIncentives() method (5% of salary if hours > 300, otherwise no incentives). 
 * Create another class Clerk (with ﬁeld salary) inherited from Emp interface. 
 * In this class override getSal() method (salary). 
 * Do not override,calcIncentives() in Clerk class. 
 * In Emp interface create a static method static double calcTotalIncome(Emp arr[]) 
 * that calculate total income (salary + incentives) of all employees in the given array.
*/

interface Emp{
	public abstract double getSal();
	default double calcIncentives() {
		return 0.0;
	}
	static double calcTotalIncome(Emp arr[]) {
		double total = 0;
		for(Emp ele :  arr) {
			total = ele.getSal() + ele.calcIncentives();
		}
		return total;
	}
}

class Manager implements Emp{
	double basicSalary;
	double dearanceAllowance;
	@Override
	public double getSal() {
		return basicSalary + dearanceAllowance;
	}
	@Override
	public double calcIncentives() {
		return 0.2*basicSalary;
	}
	
}

/*
 *  Create another class Clerk (with ﬁeld salary) inherited from Emp interface. 
 * 	In this class override getSal() method (salary).
 * 
*/

class Clerk implements Emp{
	double salary;
	@Override
	public double getSal() {
		return salary;
	}
}

/* Create another class Labor (with ﬁelds hours and rate) inherited from Emp interface. 
* In this class override getSal() method (hours * rate) 
* as well as calcIncentives() method (5% of salary if hours > 300, otherwise no incentives).*/ 

class Labor implements Emp{
	double hours;
	double rate;
	@Override
	public double getSal() {
		return rate*hours;
	}
	@Override
	public double calcIncentives() {
		if(hours > 300) {
			return 0.05 * this.getSal();
		}
		return 0;
	}
}


public class Answer {
	public static void main(String[] args) {
		Emp[] e = new Emp[5];
		Labor l = new Labor();
		l.hours = 40;
		l.rate = 12;
		e[0] = l;
		Clerk c = new Clerk();
		c.salary = 1000;
		e[1] = c;
		Manager m = new Manager();
		m.basicSalary = 10000;
		m.dearanceAllowance = 12313;
		e[2] = m;
		c = new Clerk();
		c.salary = 3214;
		e[3] = c;
		l = new Labor();
		l.hours = 350;
		l.rate = 5;
		e[4] = l;
		System.out.println(Emp.calcTotalIncome(e));
		
	}
}
