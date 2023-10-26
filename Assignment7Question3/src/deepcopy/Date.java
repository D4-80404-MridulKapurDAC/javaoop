package deepcopy;

public class Date implements Cloneable{
	int day,mon,year;

	public Date(int day, int mon, int year) {
		super();
		this.day = day;
		this.mon = mon;
		this.year = year;
	}
	
	public void setDate(int day,int month,int year) {
		this.day = day;
		this.mon = month;
		this.year = year;	
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public void display() {
		System.out.printf("%d/%d/%d",day,mon,year);
	}
	
}
