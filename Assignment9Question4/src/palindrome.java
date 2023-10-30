
public class palindrome {
	public static void main(String args[]) {
		StringBuilder s =new StringBuilder("thissiht");
		if(s.equals(s.reverse())){
			System.out.println("palindrome");
		}else {
			System.out.println("not palindrome");
		}
	}
}
