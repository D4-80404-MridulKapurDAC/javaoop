import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

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
	ADD,DISPLAY,SEARCH,DELETE_IDX,DELETE_ISBN,DELETE_NAME,SORT_ISBN,SORT_DESC,REVERSE,DISPLAY_ALL,EXIT;
}

public class Program {
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
			System.out.println("1.Add,2.Display,3.Search,4.Delete_idx,5.Delete_isbn,6.Delete_name,7.Sort_isbn,8.Sort_desc,9.Reverse,10.DisplayAll,11.EXIT");
			ch = CHOICE.values()[sc.nextInt()-1];
			switch(ch) {
				case ADD:
					Book b = new Book();
					b.accept(sc);
					int idx = arr.indexOf(b);
					if(idx != -1) {
						arr.get(idx).setQuantity(arr.get(idx).getQuantity() + b.getQuantity());
					}else {						
						arr.add(b);
					}
					break;
				case DISPLAY:
					arr.sort(new SortISBN());
					for(int i = 0 ; i <arr.size();i++) {
						System.out.println(arr.get(i));
					}
					break;
				case SEARCH:
					b = new Book();
					b.setIsbn(sc.next());
					idx = arr.indexOf(b);
					if(idx!=-1) {
						System.out.println(arr.get(idx));
					}else {
						System.out.println("Not Found");
					}
					break;
				case DELETE_IDX:
					idx = sc.nextInt();
					arr.remove(idx);
					break;
				case DELETE_ISBN:
					b = new Book();
					b.setIsbn(sc.next());
					arr.remove(b);
					break;
				case DELETE_NAME:
					b = new Book();
					b.setAuthorName(sc.next());
					for(int i = 0;i<arr.size();i++) {
						if(arr.get(i).getAuthorName().compareTo(b.getAuthorName()) == 0) {
							arr.remove(i);
							break;
						}
//						arr[i] -> arr.get(i)
					}
					break;
				case SORT_ISBN:
					Collections.sort(arr);
					break;
				case SORT_DESC:
					class DescSort implements Comparator<Book>{

						@Override
						public int compare(Book arg0, Book arg1) {
							return arg1.getPrice().compareTo(arg0.getPrice());
						}
						
					}
					Collections.sort(arr,new DescSort());
					break;
				case REVERSE:
					Collections.reverse(arr);
					break;
				case DISPLAY_ALL:
					Iterator<Book> itr = arr.iterator();
					while(itr.hasNext()) {
						Book prnt = itr.next();
						System.out.println(prnt);
					}
					break;
				default:
					break;
			}
		}while(ch!=CHOICE.EXIT);
	}
}

