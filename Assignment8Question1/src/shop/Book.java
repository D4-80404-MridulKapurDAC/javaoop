package shop;

import java.util.Objects;
import java.util.Scanner;

public class Book extends Product{
	String ISBN;
	String author;
	String subject;
	
	@Override
	public void setDetails() {
		super.setDetails();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ISBN : ");
		this.setISBN(sc.next());
		System.out.println("Enter Author : ");
		this.setAuthor(sc.next());
		System.out.println("Enter Subject : ");
		this.setSubject(sc.next());	
//		sc.close();
	}
	
	@Override
	public double getRevenue() {
		return this.price*(1-Product.discount/100);
	}
	
	@Override
	public double getSellprice() {	
		return this.price*(1-Product.discount/100);
	}
	
	public Book(String title, double price, String iSBN, String author, String subject) {
		super(title, price);
		ISBN = iSBN;
		this.author = author;
		this.subject = subject;
	}

	public Book() {
		super();
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(ISBN, author, subject);
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
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		return Objects.equals(ISBN, other.ISBN) && Objects.equals(author, other.author)
				&& Objects.equals(subject, other.subject);
	}
	
	
}
