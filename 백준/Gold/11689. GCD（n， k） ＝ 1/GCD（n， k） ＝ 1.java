import java.util.*;
import java.io.*;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		long n = Long.parseLong(br.readLine());
		long N = n;
		
		long sqrN = (long) Math.sqrt(N);
		
		for (long i = 2; i < sqrN + 1; i++) {
			if (N % i == 0) {
				n /= i;
				n *= i-1;
				
				while (N % i == 0) {
					N /= i;
				}
			}
		}
		
		if (N != 1) {
			n /= N;
			n *= N-1;			
		}
		
		bw.write(n + "");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}