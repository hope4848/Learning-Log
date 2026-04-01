package workshop04;
import java.util.Random;


public class ArrayTest10 {
	public static void main(String[] args) {
		
		Random rand = new Random();
		if (args.length !=2) {
			System.out.println("다시 입력 하세요");
			return;
		}
		
		int row = Integer.parseInt(args[0]);
		int col = Integer.parseInt(args[1]);
		
		if (row < 1 || row > 5 || col < 1 || col > 5) {
			System.out.println("숫자를 확인 하세요");
			return;
		}
		
		int[][] arr = new int[row][col];
		for (int i = 0; i<row; i++) {
			for (int j =0; j<col; j++) {
				arr[i][j] = rand.nextInt(5) + 1;
				
				System.out.print(arr[i][j] + " ");
				
			}
			System.out.println();
		}
		
		float sum = 0;
		for (int[] x : arr) {
			for (int k : x) {
				sum+=k;
			}
		}
		float avg = sum / (row*col);
		
		System.out.println("sum=" + sum);
		System.out.println("avg=" + avg);
		
	}

}
