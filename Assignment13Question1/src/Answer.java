import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Answer {
	public static void main(String args[]) {
//		Collection<String> c = new ArrayList<>();//MULTIPLE NULLS ALLOWED
//		Collection<String> c = new HashSet<>();//MULTIPLE NULLS NOT ALLOWED
//		Collection<String> c = new LinkedHashSet<>();//MULTIPLE NULLS NOT ALlOWED
		Collection<String> c = new TreeSet<>();//NULL NOT ALLOWED
		c.add("B");
		c.add("D");
		c.add("A");
		c.add("C");
		c.add(null);
		c.add(null);
		c.add(null);
		System.out.println(c.toString());
	}
}
