import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> primes = new ArrayList<>();
        primes.add(0);
        
        boolean[] isPrime = new boolean[N+1];
        for (int i=2;i<N+1;i++) {
        	if (!isPrime[i]) {
        		primes.add(i+primes.get(primes.size()-1));
        		for (int j=i;j<N+1;j+=i) {
        			isPrime[j] = true;
        		}
        	}
        }
        
        int l = 0;
        int r = 1;
        int cnt = 0;
        while (r<primes.size()) {
        	int sum = primes.get(r)-primes.get(l);
        	if (sum==N) {
        		cnt += 1;
        		r += 1;
        	}
            
        	else if (sum<N) r += 1;
        	else l += 1;
        }
        
        bw.write(cnt+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}