package workshop04;
import java.util.Arrays;
import java.util.Scanner;

//키(height)값을 입력 받아서 최대값을 구하는 코드 작업. 입력 받은 사람 수만큼 배열을 생성하여 사용.

public class ArrayTest06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수 : ");
		int people = sc.nextInt();
		int[] heightList = new int[people];
		
		for (int i=0; i<heightList.length; i++) {
			System.out.print("사람 " + (i+1) + ": ");
			heightList[i]= sc.nextInt();
			
		}
		Arrays.sort(heightList);
		int max = heightList[heightList.length-1];
		System.out.println("최댓값은 " + max + "입니다.");
		
		sc.close();
		
		
	}

}
