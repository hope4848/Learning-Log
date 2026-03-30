/*
 * 다음과 같은 조건을 만족하는 프로그램을 작성하시오.
 * 
 * 변수 선언이 아래와 같이 되어 있을 때 실행 결과와 같이 출력 될 수 있도록 프로그램 하시오.
 */

package com.workshop02;

public class Test05 {
	public static void main(String[] args) {
		byte a = 10;
		byte b = 20;
		byte c = (byte)(a+b);
		char ch = 'A';
		ch = (char)(ch+2);
		float f = 3 / 2.0f;
		long l = 27000000000L;
		float f2 = 0.1f;
		double d = 0.1;
		boolean result = (float)d == f2 ;
		
		System.out.println("c="+c);
		System.out.println("ch="+ch);
		System.out.println("f="+f);
		System.out.println("l="+l);
		System.out.println("result="+result);
	}

}
