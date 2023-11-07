import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

enum CHOICE{
	ADD,DISPLAY,SEARCH,DELETE_IDX,DELETE_ISBN,DELETE_NAME,SORT_ISBN,SORT_DESC,REVERSE,DISPLAY_ALL,ADDTOFILE,GETFROMFILE,EXIT;
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
			System.out.println("1.Add,2.Display,3.Search,4.Delete_idx,5.Delete_isbn,6.Delete_name,7.Sort_isbn,8.Sort_desc,9.Reverse,10.DisplayAll,11.ADDtofile,12.get from file,13.EXIT");
			ch = CHOICE.values()[sc.nextInt()-1];
			switch(ch) {
				case ADDTOFILE:
					Book b = new Book();
					b.accept(sc);
					try {
						FileOutputStream fos = new FileOutputStream("books.txt",true);
						DataOutputStream dos = new DataOutputStream(fos);
						dos.writeUTF(b.getIsbn());
						dos.writeUTF(b.getAuthorName());
						dos.writeDouble(b.getPrice());
						dos.writeInt(b.getQuantity());
					}catch(Exception e){
						e.printStackTrace();
					}
					break;
				case GETFROMFILE:
					b = new Book();
					try {
						FileInputStream fin = new FileInputStream("books.txt" );
						DataInputStream din = new DataInputStream(fin);
						while(true) {
							b.setAuthorName(din.readUTF());
							b.setIsbn(din.readUTF());
							b.setPrice(din.readDouble());
							b.setQuantity(din.readInt());
							System.out.println(b);
						}

					}catch(EOFException e) {
						
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					break;
				case ADD:
					b = new Book();
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
					String authorName = sc.next();
					arr.removeIf((a) -> a.getAuthorName().compareTo(authorName) == 0);
					break;
				case SORT_ISBN:
					Collections.sort(arr);
					break;
				case SORT_DESC:
					Collections.sort(arr,(fir,sec)->fir.getPrice().compareTo(sec.getPrice()));
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
