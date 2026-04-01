package workshop04;
import java.util.Random;

// 다음과 같이 선언되어 있는 배열에 1~10까지 랜덤한 숫자(중복허용)을 넣고 이 배열에 어떤
//값이 셋팅 되어있는지 출력하고 배열 데이터의 합과 평균을 구하는 프로그램 작성.
// 합은 정수형, 평균은 실수형으로 출력

public class ArrayTest09 {
	public static void main(String[] args) {
		Random rand = new Random();
		int[] arr3 = new int[5];
		int sum = 0;
		for (int i=0; i<arr3.length; i++) {
			arr3[i] = rand.nextInt(10) + 1;
			System.out.print(arr3[i] + " ");
		}
		for (int i=0; i<arr3.length; i++) {
			sum+=arr3[i];
		}
		float avg = (float) sum / arr3.length;
		
		System.out.println("\nsum=" + sum);
		System.out.println("avg=" + avg);
		
	}
}
