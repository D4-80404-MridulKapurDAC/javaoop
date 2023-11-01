package Generics;
import java.util.ArrayList;

class Integer implements Comparable<Integer>{
	
}

class s extends ArrayList<Integer>{
	
}

class a extends ArrayList<Object>{
	
}

public class Gen2 {
	public <T> void find(Gen1<? extends Gen3<? super T> , ? , ? extends ArrayList<Integer> > val) {
		
	}
	
	
	public static void main(String[] args) {
		s obj1 = new s();
		a obj2 = new a();
		fn2(obj2);
	}

}


//Comparable<Integer>
//
//? extends Comparable<Integer> 