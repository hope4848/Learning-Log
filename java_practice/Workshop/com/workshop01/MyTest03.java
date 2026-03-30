/*
 * 다음과 같은 변수에 값이 저장되어 있을 때, 두 변수의 값을 바꾸는 코드를 작성하시오.
 * (즉, n 변수에는 20을 저장하고 n2 변수에는 10이 저장되도록 한다. 직접 입력하지 말고 변수를 통해서 값이 바뀌어야 한다.)
 * 
 * 
 */


package com.workshop01;

public class MyTest03 {
	public static void main(String[] args) {
		
		int n = 10;
		int n2 = 20;
		
		int n3 = n;
		n = n2;
		n2 = n3;
		
		System.out.println("n값은 " + n);
		System.out.println("n2값은 " + n2);
		
	}

}
