package q3;

public class Q3 {
	public static void main(String args[]) {
		String sentence = "From an array of strings print the strings ending with vowels";
		String[] arr = sentence.split(" ");
		for(String st : arr) {
			char end = st.charAt(st.length()-1);
			if( end == 'a' || end =='e' || end =='i' || end=='o' || end =='u' ) {
				System.out.println(st);
			}
		}
	}
}
