package workshop04;

//다음 배열의 합과 평균을 구하는 프로그램을 작성 하시오.

public class ArrayTest01 {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum = sum + arr[i];
		}
		int avg = sum / arr.length;
		
		System.out.println("sum=" + sum);
		System.out.println("avg=" + avg);

	}

}
