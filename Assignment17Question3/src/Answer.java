import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Answer {
	public static void main(String[] args) {
		IntSummaryStatistics x = IntStream.range(1, 10).summaryStatistics();
		System.out.println(x);
	}
}
