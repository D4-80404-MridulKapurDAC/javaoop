package shop;

import java.util.Objects;
import java.util.Scanner;

public abstract class Product {
	String title;
	double price;
	static double discount = 10;
	
	protected abstract double getSellprice();
	protected abstract double getRevenue();
	
	public void setDetails() {
		Scanner sc = new Scanner(System.in); 
		this.setTitle(sc.next());
		this.setPrice(sc.nextDouble());
//		sc.close();
	}
	
	public Product(String title, double price) {
		super();
		this.title = title;
		this.price = price;
	}
	public Product() {}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}	
	public double getDiscount() {
		return discount;
	}
	public static void setDiscount(double discount) {
		Product.discount = discount;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(price, title);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		return price == other.price && Objects.equals(title, other.title);
	}
	
}
