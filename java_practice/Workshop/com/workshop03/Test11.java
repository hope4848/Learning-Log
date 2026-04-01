package workshop03;
import java.util.Scanner;

//키보드로 두 개의 정수값을 입력 받아서 a와 b변수에 저장하고 b-a값 출력
//단 b가 a보다 작으면 b 다시 입
public class Test11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("a의 값 : ");
		int a = sc.nextInt();
		while (true) {
			System.out.print("b의 값 : ");
			int b = sc.nextInt();
			if (b<a) {
				System.out.println("a보다 큰 값을 입력하세요!");
				continue;
			} else {
				System.out.println("b - a는 " + (b-a) + "입니다");
				break;
			}
		}
		
		sc.close();
		
		
	}

}
