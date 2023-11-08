import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Answer {
	public static void main(String[] args) {
		Integer x = Stream
					.generate(() -> (int)(Math.random() * 100.0))
					.limit(10)
					.reduce(0,(a,b) -> a+b);
		System.out.println(x);
	}
}
