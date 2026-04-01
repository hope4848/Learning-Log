package workshop03;
import java.util.Scanner;
//조건 1부터 100까지 더하는 프로그램을 작성한다. 단, Scanner로 1자리 정수형 데이터를 입력 받아 입력 받은 수의 배수만 더한다.
//입력 예 : 5
//5, 10,15 ... 의 합

public class Test07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("한 자리 정수값을 입력하시오");
		int num = sc.nextInt();
		int sum = 0;
		
		for (int i = 1; i<=100; i++) {
			if (i % num == 0) {
				sum+=i;
				
				System.out.print(i);
				
				if (i+num<=100) {
					System.out.print("+");
				} else {
					System.out.print(" = ");
				}
			}
		}
		System.out.println(sum);
		sc.close();
		
	}

}
