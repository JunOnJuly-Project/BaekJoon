import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int N = Integer.parseInt(br.readLine());
	    
	    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
	    	long absA = Math.abs(a);
	    	long absB = Math.abs(b);
	    	
	    	if (absA == absB) {
	    		return Integer.compare(a, b);
	    	}
	    	
	    	else {
	    		return Long.compare(absA, absB);
	    	}
	    });
	    
	    for (int i = 0; i < N; i ++) {
	    	int query = Integer.parseInt(br.readLine());
	    	
	    	if (query == 0) {
	    		if (pq.isEmpty()) {
	    			bw.write(0 + "\n");
	    		}
	    		
	    		else {
	    			bw.write(pq.poll() + "\n");
	    		}
	    	}
	    	
	    	else {
	    		pq.add(query);
	    	}
	    }
	    
	    // 출력
	    br.close();
	    bw.flush();
	    bw.close();
	  }
	  
	  public static void main(String[] args) throws Exception {
	      new Main().solution();
	  }
}