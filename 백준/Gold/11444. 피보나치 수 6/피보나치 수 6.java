import java.io.*;
import java.util.*;


public class Main {
	public Long fib(Map<Long, Long> memo, Long n) throws Exception {
		if (memo.containsKey(n)) return memo.get(n);
		
		if (n%2==0) {
			long fibN = (fib(memo, n/2+1)*fib(memo,  n/2+1) - fib(memo, n/2-1)*fib(memo, n/2-1))%1000000007;
			if (fibN<0) fibN += 1000000007;
			memo.put(n, fibN);
			return fibN;
		}
		
		else {
			long fibN = (
							(fib(memo, (n-1)/2+1)*fib(memo, (n-1)/2+1))%1000000007 + 
							(fib(memo, (n-1)/2)*fib(memo, (n-1)/2))%1000000007
						)%1000000007;
			memo.put(n, fibN);
			return fibN;
		}
	}
	
	
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Long n = Long.parseLong(br.readLine());
        
        Map<Long, Long> memo = new HashMap<>();
        memo.put(0L, 0L);
        memo.put(1L, 1L);
        memo.put(2L, 1L);
        
        bw.write(fib(memo, n)+"");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}