package iterators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class concurrentSet {
	public static void main(String[] args) {
		CopyOnWriteArrayList<Integer> arr = new CopyOnWriteArrayList<Integer>();
		Collections.addAll(arr,1,2,3,4,4,5,6,7);
		Iterator<Integer> itr = arr.iterator();
		Iterator<Integer> itr2 = arr.iterator();
		int idx = 0;
		while(itr.hasNext()) {
			arr.set(idx,0);
			Integer curr = itr.next();
			System.out.println(curr);
			if(idx ==5) {
				itr2 = arr.iterator(); 
			}
			idx++;
		}
		idx = 0;
		while(itr2.hasNext()) {
			Integer curr = itr2.next();
			System.out.println(curr);
			idx++;
		}
		System.out.println(arr);
		ArrayList<Integer> arrC= new ArrayList<Integer>();
		Collections.addAll(arrC,1,2,3,4,4,5,6,7);
		itr = arrC.iterator();
		idx = 0;
		while(itr.hasNext()) {
			arrC.set(idx,0);
			idx++;
			Integer curr = itr.next();
			System.out.println(curr);	
		}
	}

}
