import java.util.Scanner;
import java.util.stream.Stream;

public class Answer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sada
		int x = Stream.iterate(1,a->{ System.out.println(a);return a+1;})
				.limit(sc.nextInt())
				.reduce(1,(a,b) ->{System.out.println("lim");return a*b;});
		System.out.println(x);
	}

}
