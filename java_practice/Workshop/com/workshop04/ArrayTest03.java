package workshop04;

//2차원 배열 arr2에 담긴 모든 값의 총합과 평균을 구하는 프로그램을 작성 하시오.

public class ArrayTest03 {
	public static void main(String[] args) {
		int[][] arr2 = {
		{5, 5, 5, 5, 5},
		{10, 10, 10, 10, 10},
		{20, 20, 20, 20, 20},
		{30, 30, 30, 30, 30}
		};		
		
		int total =0;
		int count = 0;
		for (int[] x : arr2)
			for (int k : x) {
				total+=k;
				count++;
			}
		System.out.println("total=" + total);
		float average = (float) total / count;
		System.out.println("average=" + average);
	}

}
