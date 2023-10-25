package company;

abstract class Employees {
	String ssn = "";
	String fname;
	String lname;
	
	@Override
	public String toString(){
		return ssn;
	}
	
	abstract public double calc();
	
	public Employees(String ss,String fn,String ln) {
		ssn = ss;
		fname = fn;
		lname = ln;
	}
	
	 public String typeOf(){
		 return getClass().getName();
	 }
}


class Salaried extends Employees{
	double weeklySal;
	@Override
	public double calc() {
		return weeklySal;
	}
	
	@Override
	public String toString() {
		return weeklySal+super.toString();
	}

	public Salaried(String ss, String fn, String ln, double weeklySal) {
		super(ss, fn, ln);
		this.weeklySal = weeklySal;
	}
	
	@Override
	public String typeOf(){
		 return getClass().getName();
	 }
}

class Hourly extends Employees{
	double wage;
	int hours;
	@Override
	public double calc() {
		if(hours <= 40) {
			return wage*hours;
		}
		else {
			return 40*wage + (hours-40)*wage*1.5;
		}
	}
	
	@Override
	public String toString() {
		return wage+" "+hours+" "+super.toString();
	}

	public Hourly(String ss, String fn, String ln, double wage, int hours) {
		super(ss, fn, ln);
		this.wage = wage;
		this.hours = hours;
	}
	@Override
	public String typeOf(){
		 return getClass().getName();
	 }
	
}

class Commission extends Employees{
	int grossSales;
	double commissionRate;
	@Override
	public double calc() {
		return commissionRate*grossSales;
	}
	@Override
	public String toString() {
		return grossSales+" "+commissionRate+" "+ super.toString();
	}
	public Commission(String ss, String fn, String ln, int grossSales, double commissionRate) {
		super(ss, fn, ln);
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}
	
	@Override
	public String typeOf(){
		 return getClass().getName();
	 }
}

class CommissionBase extends Commission{
	double base;
	@Override
	public double calc() {
		return commissionRate*grossSales+base;
	}
	@Override
	public String toString() {
		return base+" "+super.toString();
	}
	
	public void setBase(double val) {
		base = val;
	}
	
	public double getBase() {
		return base;
	}
	public CommissionBase(String ss, String fn, String ln, int grossSales, double commissionRate, double base) {
		super(ss, fn, ln, grossSales, commissionRate);
		this.base = base;
	}	

	@Override
	public String typeOf(){
		 return getClass().getName();
	 }
}