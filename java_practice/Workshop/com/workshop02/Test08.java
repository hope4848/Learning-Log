/*
 * 다음과 같은 조건을 만족하는 프로그램을 작성하시오.
 * Scanner 클래스를 사용하여 키보드로 두 개의 정수값을 입력 받아서 더하는 코드 작업
 */

package com.workshop02;
import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.정수 입력하세요");
		int a = sc.nextInt();
		System.out.println("2.정수 입력하세요");
		int b = sc.nextInt();
		System.out.println("정수 " + a + " 과 정수 " + b + " 의 합계:" + (a+b));
		sc.close();
	}

}
