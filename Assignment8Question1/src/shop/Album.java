package shop;

import java.util.Objects;
import java.util.Scanner;

public class Album extends Product{
	String singer;
	String musician;
	double tax = 10;
	
	@Override
	public void setDetails() {
		super.setDetails();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Singer : ");
		this.setSinger(sc.next());
		System.out.println("Enter Musician : ");
		this.setMusician(sc.next());
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
	
	public Album(String title, double price, String singer, String musician) {
		super(title, price);
		this.singer = singer;
		this.musician = musician;
	}
	public Album() {
		super();
	}

	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getMusician() {
		return musician;
	}
	public void setMusician(String musician) {
		this.musician = musician;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(musician, singer);
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
		if (!(obj instanceof Album)) {
			return false;
		}
		Album other = (Album) obj;
		return Objects.equals(musician, other.musician) && Objects.equals(singer, other.singer);
	}
	
}
