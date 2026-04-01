package workshop04;
import java.util.Arrays;

//다음과 같이 제공된 배열에서 최댓값, 최솟값 구하는 코드

public class ArrayTest08 {
	public static void main(String[] args) {
		int [] score = {99, 34, 67, 22, 11, 9};
		
		Arrays.sort(score);
		
		System.out.println("최댓값:" + score[score.length-1]);
		System.out.println("최솟값:" + score[0]);
		
		
	}

}
