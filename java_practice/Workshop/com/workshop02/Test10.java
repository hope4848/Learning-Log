/*
 * Scanner 클래스를 사용하여 키보드로 주소값을 입력 받아서 도/시/구 이름을 출력하는 코
 * 
 */

package com.workshop02;
import java.util.Scanner;

public class Test10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("주소를 입력하시오.");
		String doName = sc.next();
		String siName = sc.next();
		String guName = sc.next();
		System.out.println("도명: " + doName);
		System.out.println("시명: " + siName);
		System.out.println("구명: " + guName);
		sc.close();
	}

}
