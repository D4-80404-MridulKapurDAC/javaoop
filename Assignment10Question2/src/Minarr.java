public class Minarr {

	public static <T extends Number> T findmin(T[] arr) {
		if(arr.length == 0) {
			Integer num = new Integer(5);
//			T n1 = (T) num;
//			T[] n1 = new T[5];
			return (T) num;//DOUBT
		}
		
		int minIdx = 0;
		for(int i = 0 ; i<arr.length;i++) {
			if(arr[i].doubleValue() < arr[minIdx].doubleValue()) {
				minIdx = i;
			}
		}
		return arr[minIdx];
	}
	
	public static void main(String[] args) {
		Integer arr[] = {};
		System.out.println(findmin(arr));
	}

}
