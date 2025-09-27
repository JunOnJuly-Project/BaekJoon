import java.io.*;
import java.util.*;

public class Main {
	int[] memo;
	
	int fib(int N) {
		if (memo[N] != -1) {
			return memo[N];
		}
		
		memo[N] = (fib(N - 1) + fib(N - 2)) % 1000000007;
		
		return memo[N];
	}
	
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        memo = new int[Math.max(N + 1, 2)];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
        
        bw.write(fib(N) + "");
        
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}