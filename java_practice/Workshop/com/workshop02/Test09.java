/*
 *Scanner 클래스를 사용하여 키보드로 두 개의 정수값을 입력 받아서 최대값을 구하는 코드 작
 *단, 3항 연산자만 사용할 
 */

package com.workshop02;
import java.util.Scanner;

public class Test09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1.정수 입력하세요.");
		int a = sc.nextInt();
		System.out.println("2.정수 입력하세요.");
		int b = sc.nextInt();
		int result = (a>b) ? a:b; 
		System.out.println("정수 " + a + " 과" + " 정수 " + b + " 중에서 최대값: " + result);
		sc.close();
	}

}
