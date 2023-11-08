package overriding;

import java.util.ArrayList;

interface Cmp<T>{
	public int cmpto(T a);
}

class Book implements Cmp<Book>{
	public int x =20;

	public Book(int t) {
		x = t;
	}
	
	@Override
	public int cmpto(Book b) {
		return (this.x - b.x ); 
	}
}

class TreeS<T>{
	ArrayList<T> ls;
	
	public int isGreater(T a, T b){
		Cmp<T> ref1 = (Cmp<T>) a;
		Cmp<T> ref2 = (Cmp<T>) b;
		return ref1.cmpto(b);
	}
}



public class tst{
	public static void main(String[] args) {
		TreeS<Book> lis =  new TreeS<Book>();
		System.out.println(lis.isGreater(new Book(4),new Book(6)));
		
	}
}
