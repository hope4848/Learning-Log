package workshop03;

//	 1부터 100까지 반복하면서 3의 배수는 foo, 5의 배수는 bar, 7의 배수는 baz 값을 출력하는 프로그램을 작성하시오.

public class Test08 {
	public static void main(String[] args) {
		for (int i=1; i<=100; i++) {
			String res = i + " ";
			
			if (i % 3 ==0) res += "foo ";
			if (i % 5 ==0) res += "bar ";
			if (i % 7 ==0) res += "baz ";
			
			System.out.println(res.trim());
		}
	}

}
