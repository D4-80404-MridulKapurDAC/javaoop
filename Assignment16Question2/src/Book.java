import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

class Book implements Comparable<Book>,Serializable{
	private static final long serialVersionUID = 1L;
	String isbn;
	Double price;
	String authorName;
	Integer quantity;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Book(String isbn, Double price, String authorName, Integer quantity) {
		super();
		this.isbn = isbn;
		this.price = price;
		this.authorName = authorName;
		this.quantity = quantity;
	}
	
	public Book() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(authorName, isbn, price, quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		return Objects.equals(isbn, other.isbn);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [isbn=").append(isbn).append(", price=").append(price).append(", authorName=")
				.append(authorName).append(", quantity=").append(quantity).append("]");
		return builder.toString();
	}
	public void accept(Scanner sc) {
		System.out.print("Enter isbn : ");
		this.isbn = sc.next();
		System.out.print("Enter price : ");
		this.price = sc.nextDouble();
		System.out.print("Enter author : ");
		this.authorName = sc.next();
		System.out.print("Enter quantity : ");
		this.quantity = sc.nextInt();
	}
	@Override
	public int compareTo(Book arg0) {
		return this.isbn.compareTo(arg0.isbn);
	}
	
}