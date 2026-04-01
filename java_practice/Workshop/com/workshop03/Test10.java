package workshop03;
import java.util.Scanner;

//키보드로 정수값을 입력 받아서 1부터 입력 받은 정수값까지의 총 합을 구하는 실습.
//단, 음수 및 0을 입력 한 경우에는 다시 입력 받는다.

public class Test10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1부터 n까지의 총합 구하기");
		
		while (true) {
			System.out.print("n의 값: ");
			int num = sc.nextInt();
			int sum= 0;
			if (num <=0) {
				System.out.println("양의 정수만 됩니다.");
				continue;
			} else {
				for (int i = 1; i<=num; i++) {
					sum+=i;
				}
			}
			System.out.println("1부터 " + num + " 까지의 총합: " + sum);
			break;
		}
		
		sc.close();
		
	}

}
