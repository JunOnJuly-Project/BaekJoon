import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N, K;
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    int[] coins = new int[N];
	    for (int i = 0; i < N; i++) {
	    		coins[i] = Integer.parseInt(br.readLine());
	    }
	    
	    int result = 0;
	    for (int i = N - 1; i >= 0; i--) {
		    	if (K == 0) {
		    		break;
		    	}
		    	
	    		int div, mod;
	    		div = K / coins[i];
	    		mod = K % coins[i];
	    		
	    		if (div > 0) {
	    			result += div;
	    			K = mod;
	    		}
	    }
	    
	    // 출력
	    bw.write(result + "");
	    br.close();
	    bw.flush();
	    bw.close();
	  }
	  
	  public static void main(String[] args) throws Exception {
	      new Main().solution();
	  }
}