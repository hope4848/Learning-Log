package workshop03;
import java.util.Scanner;

//Scanner 이용하여 임의의 정수값을 입력받고, 입력 받은 정수값만큼 1부터 반복한다.
//이때 짝수값의 총합과 평균값을 출력하시오.

public class Test05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하시오");
		int num = sc.nextInt();
		float sum = 0;
		int sum2 = 0;
		for (int i = 0; i<=num; i++) {
			sum+=i;
			if (i % 2 == 0) {
				sum2+=i;
			}
			
		}
		System.out.println("총합:" + sum2);
		System.out.println("평균값:" + (sum / num));	
		
		
		
		
		
		
		sc.close();
		
		
	}

}
