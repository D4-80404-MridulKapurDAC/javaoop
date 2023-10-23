package question3;

public class Date {
	private  int year = 1;
	private int month = 1;
	private int day = 1;
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	void displayDate() {
		System.out.println(this.day+"/"+this.month+"/"+this.year);
	}
	
}
