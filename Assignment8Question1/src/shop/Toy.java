package shop;

import java.util.Objects;
import java.util.Scanner;

public class Toy extends Product {
	String age_group;
	String type;
	double tax = 5;
	
	@Override
	public void setDetails() {
		super.setDetails();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter age group : ");
		this.setAge_group(sc.next());
		System.out.println("Enter type : ");
		this.setType(sc.next());
//		sc.close();
	}
	
	@Override
	public double getRevenue() {
		return this.price*(1-Product.discount/100);
	}
	
	@Override
	public double getSellprice() {	
		return (this.price*(1-Product.discount/100))*(1+tax/100);
	}
	
	public Toy(String title, double price, String age_group, String type) {
		super(title, price);
		this.age_group = age_group;
		this.type = type;
	}
	public Toy() {
		super();
	}

	public String getAge_group() {
		return age_group;
	}
	public void setAge_group(String age_group) {
		this.age_group = age_group;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(age_group, type);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Toy)) {
			return false;
		}
		Toy other = (Toy) obj;
		return Objects.equals(age_group, other.age_group) && Objects.equals(type, other.type);
	}
	
	
	
}
