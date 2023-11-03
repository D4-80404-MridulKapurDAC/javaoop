import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
 * In above assignment, Use TreeSet to store all books in descending order of price. Natural ordering for the Book should be isbn (do not change it). Display
 * them using iterator() and descendingIterator().
*/

class Book implements Comparable<Book>{
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
//	@Override
//	public int hashCode() {
//		return Objects.hash(isbn);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (!(obj instanceof Book)) {
//			return false;
//		}
//		Book other = (Book) obj;
//		return Objects.equals(isbn, other.isbn);
//	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [isbn=").append(isbn).append(", price=").append(price).append(", authorName=")
				.append(authorName).append(", quantity=").append(quantity).append("]");
		return builder.toString();
	}
//	public void accept(Scanner sc) {
//		System.out.print("Enter isbn : ");
//		this.isbn = sc.next();
//		System.out.print("Enter price : ");
//		this.price = sc.nextDouble();
//		System.out.print("Enter author : ");
//		this.authorName = sc.next();
//		System.out.print("Enter quantity : ");
//		this.quantity = sc.nextInt();
//	}
	@Override
	public int compareTo(Book arg0) {
		return this.isbn.compareTo(arg0.isbn);
	}
	
}


public class Answer {
	public static void main(String[] args) {
		class DescPrice implements Comparator<Book>{

			@Override
			public int compare(Book arg0, Book arg1) {
				return arg1.getPrice().compareTo(arg0.getPrice());
			}
			
		}
		TreeSet<Book> b = new TreeSet<Book>(new DescPrice());
//		LinkedHashSet<Book> b = new LinkedHashSet<Book>();
//		HashSet<Book> b = new HashSet<Book>();
		b.add(new Book("ISBN1",20.0,"Auth1132",122));
		b.add(new Book("ISBN3",220.0,"Auth1431",142));
		b.add(new Book("ISBN5",2310.0,"Auth2131",102));
		b.add(new Book("ISBN21",2450.0,"Auth31",126));
		b.add(new Book("ISBN21",210.0,"Auth11",142));
		b.add(new Book("ISBN51",204.0,"Auth13",112));
		b.add(new Book("ISBN31",204.0,"Auth13",112));
		Iterator<Book> itr = b.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		Iterator<Book>itrRev = b.descendingIterator();
		while(itrRev.hasNext()) {
			System.out.println(itrRev.next());
		}
	}
}
