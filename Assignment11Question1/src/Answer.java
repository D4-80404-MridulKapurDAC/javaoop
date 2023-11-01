import java.util.Comparator;

public class Answer {
	static <T extends Number> void selectionSort(T[] arr, Comparator<T> c) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(c.compare(arr[i], arr[j]) > 0) {
					T temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(T e : arr) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		Double[] arr = {1.2,1.0,0.9,21.1,213.23,12.0};
		class Srt implements Comparator<Double>{

			@Override
			public int compare(Double arg0, Double arg1) {
				return Double.compare(arg0,arg1);
			}			
		}
		selectionSort(arr,new Srt());
	} 
	
}
