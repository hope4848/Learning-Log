/*
 * 다음과 같은 조건을 만족하는 프로그램을 작성 하시오.
 * 다음 아스키 코드값을 활용할 수 있다.
 * ascii 값 'A' -> 65
 * ascii 값 'B' -> 66
 * ascii 값 '1' -> 49
 * ascii 값 '2' -> 50
 */

package com.workshop02;

public class Test01 {
	public static void main(String[] args) {
		String s1 = "1";
		String s2 = "2";
		boolean bnx = false;
		char c1 = 'A';
		char c2 = 'B';
		char c3 = '1';
		char c4 = '2';
		int inx = 2;
		
		System.out.println(s1 + s2);
		System.out.println(!bnx);
		System.out.println(c1+c2);
		System.out.println(c3+inx);
		System.out.println(c3+c4);
	}

}
