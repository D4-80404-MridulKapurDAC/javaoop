import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

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



enum CHOICE{
	ADD,DISPLAY,DELETE_ID,FIND_ISBN,DELETE_ALL,DISPLAY_CNT,EXIT;
}

public class Answer {
	public static void main(String[] args) {
		ArrayList<Book> arr= new ArrayList<Book>();
		Scanner sc = new Scanner(System.in);
		CHOICE ch;
		class SortISBN implements Comparator<Book>{
			@Override
			public int compare(Book arg0, Book arg1) {
				return arg0.getIsbn().compareTo(arg1.getIsbn());
			}
		}
		do {
			System.out.println("1.Add,2.Display,3.DeleteId,4.FIND_ISBN,5.DELETE_ALL,6.DISPLAY_CNT,7.EXIT");
			ch = CHOICE.values()[sc.nextInt()-1];
			switch(ch) {
				case ADD:
					arr.add(new Book());
					arr.get(arr.size()-1).accept(sc);
					break;
				case DISPLAY:
					arr.sort(new SortISBN());
					for(Book b : arr) {
						System.out.println(b);
					}
					break;
				case DELETE_ID:
					Book temp = new Book();
					temp.setIsbn(sc.next());
					arr.remove(temp);
					break;
				case FIND_ISBN:
					String toFin = sc.next();
					for(int i = 0 ; i < arr.size();i++) {
						if(arr.get(i).getIsbn().compareTo(toFin) == 0) {
							System.out.println(arr.get(i));
							break;
						}
					}
					break;
				case DELETE_ALL:
					arr.removeAll(arr);
				case DISPLAY_CNT:
					System.out.println(arr.size());
					
			}
		}while(ch!=CHOICE.EXIT);
	}
}
