/*
 * 다음과 같은 조건을 만족하는 프로그램을 작성하시오.
 * Scanner 클래스를 사용하여 키보드로 값을 입력 받아서 실행 결과와 같이 출력하시오.
 * 
 */

package com.workshop02;
import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.이름을 입력하세요.");
		String name = sc.next();
		System.out.println("2.나이를 입력하세요.");
		int age = sc.nextInt();
		System.out.println("이름은 " + name + ", 나이는 " + age + " 입니다");
		sc.close();
	}

}
