import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] ns = new int[2];
		int[][] n = new int[2][3];
		
		for (int i=0;i<2;i++) {
			int num = Integer.parseInt(br.readLine());
			ns[i] = num;
			int j = 2;
			while(num > 0) {
				int div = num / (int)Math.pow(10, j);
				n[i][2-j] = div;
				num -= div * (int)Math.pow(10, j);
				j -= 1;
			}
		}
		
		for (int i=2;i>=0;i--) {
			System.out.println(ns[0] * n[1][i]);
		}
		System.out.println(ns[0] * ns[1]);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}