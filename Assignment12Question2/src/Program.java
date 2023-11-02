import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Program {
	public static void main(String[] args) {
		class LenComp implements Comparator<String>{

			@Override
			public int compare(String arg0, String arg1) {
				return arg0.length() - arg1.length();
			}
		}
		ArrayList<String> s1 = new ArrayList<String>();
		Collections.addAll(s1,"strin1","str","string41","sad");
		String ans = Collections.max(s1,new LenComp());
		System.out.println(ans);
	}
}
