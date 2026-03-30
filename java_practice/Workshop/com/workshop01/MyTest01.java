/*
 * 다음 데이터를 변수에 저장한 후, 변수를 사용하여 실행 결과와 같이 두 줄로 출력하시오.
 * (단, println, print, printf 메서드를 각각 사용한다. )
 * 홍길동20
 * 서울
 */

package com.workshop01;

public class MyTest01 {
	public static void main(String[] args) {
		String name = "홍길동";
		int age = 20;
		String city = "서울";
		
		System.out.println("1.println 사용\n이름은 " + name + "\n나이는 " + age + " 이고 주소는 " + city);
		System.out.print("2.print 사용\n이름은 " + name + "\n나이는 " + age + " 이고 주소는 " + city);
		System.out.printf("\n3. printf 사용\n이름은 %s \n나이는 %d 이고 주소는 %s", name, age, city);
	}

}
