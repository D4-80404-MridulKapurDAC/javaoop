package strings;

public class Q2 {

	public static void main(String[] args) {	
		String s = "Bank Of Maharashtra";
		String[] sp = s.split(" ");
		s = "";
		for(String s_ : sp) {
			s += s_.substring(0,1);
		}
		System.out.println(s);
		
		s = "thIs is string";
		sp = s.split(" ");
		s = "";
		for(String s_ : sp) {
			s += s_.substring(0,1).toUpperCase() + s_.substring(1).toLowerCase();
			s += " ";
		}
		s = s.substring(0,s.length()-1);
		System.out.println(s);
		
		StringBuffer str = new StringBuffer("Example");
		for(int i = 0 ; i < str.length();i++) {
			if(i%2==0) {				
				str.replace(i,i+1,str.substring(i,i+1).toUpperCase());
			}else {
				str.replace(i,i+1,str.substring(i,i+1).toLowerCase());
			}
		}
		System.out.println(str);
	}

}
