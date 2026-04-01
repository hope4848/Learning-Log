package workshop04;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

// 입력 받은 수 만큼 랜덤하게 키(height) 값을 구하여 실행결과와 같이 출력

public class ArrayTest07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수 : ");
		int people = sc.nextInt();
		int[] heightList = new int[people];
		
		for (int i = 0; i<heightList.length; i++) {
			heightList[i] = 110 + rand.nextInt(91);
			System.out.println("사람 " + (i+1) + ": " + heightList[i]); 
		}
		
		Arrays.sort(heightList);
		System.out.println("최댓값은 " + heightList[heightList.length-1] + "입니다.");
		sc.close();
		
		
		
		
	}

}
