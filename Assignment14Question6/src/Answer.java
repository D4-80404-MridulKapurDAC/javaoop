interface Check<T>{
	abstract boolean compare(T x, T y);
}

public class Answer {
	static <T> int countIf(T[] arr,T key, Check<T> c) {
		int cnt = 0;
		for(T ele : arr) {
			System.out.println(ele + " " + key);
			if(c.compare(ele, key)) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Double [] arr = {44.5,99.3,44.5, 77.0, 99.0, 22.0, 55.0, 66.4};
		Double key = 44.5;
		int cnt = countIf(arr, key, (x,y)-> x.equals(y));
		System.out.println("Count = " + cnt);
	}
}
