import java.util.Arrays;
import java.util.Comparator;

class Student{
	private int roll;
	private String name;
	private String city;
	private double marks;
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public Student(int roll, String name, String city, double marks) {
		super();
		this.roll = roll;
		this.name = name;
		this.city = city;
		this.marks = marks;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [roll=").append(roll).append(", name=").append(name).append(", city=").append(city)
				.append(", marks=").append(marks).append("]");
		return builder.toString();
	}
	
}

public class Answer {
	public static void main(String[] args) {
		class SortByCityAMarksDNameA implements Comparator<Student>{

			@Override
			public int compare(Student arg0, Student arg1) {
				int val = arg0.getCity().compareTo(arg1.getCity());
				if(val!=0)return val;
				val = ((Double)arg1.getMarks()).compareTo(arg0.getMarks());
				if(val!=0)return val;
				val = arg0.getName().compareTo(arg1.getName());
				return val;
			}
			
		}
		SortByCityAMarksDNameA sorter = new SortByCityAMarksDNameA();
		Student[] s = {
				new Student(1,"Name5","City1",59.23),
				new Student(1,"Name4","City2",12.23),
				new Student(1,"Name3","City2",50.23),
				new Student(1,"Name1","City1",50.23),
				new Student(1,"Name2","City1",50.23),
				new Student(1,"Name6","City4",50.23),
				new Student(1,"Name7","City3",50.23),
		};
		Arrays.sort(s,sorter);
		for(Student t : s) {
			System.out.println(t);
		}
	}
}
