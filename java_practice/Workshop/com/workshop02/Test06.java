/*
 * 다음과 같은 조건을 만족하는 프로그램을 작성하시오.
 * 
 *  선언된 정수형 데이터가 홀수인지 짝수인지 출력한다.
 *  단, 연산처리는 삼항 연산자를 이용한다.
 *  
 */
package com.workshop02;

public class Test06 {
	public static void main(String[] args) {
		int i = 5;
		String result = (i%2==0)?"짝수":"홀수";
		System.out.println("선언 변수 " + i + "일때 결과:\n숫자 " + i +"는 " + result + "입니다");
	}

}
