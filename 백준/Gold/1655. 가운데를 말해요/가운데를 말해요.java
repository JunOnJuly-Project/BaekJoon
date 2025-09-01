import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	    PriorityQueue<Integer> leftPq = new PriorityQueue<Integer>((a, b) -> b - a);
	    PriorityQueue<Integer> rightPq = new PriorityQueue<Integer>((a, b) -> a - b);
	    
	    int N = Integer.parseInt(br.readLine());
	    
	    for (int i = 0; i < N; i++) {
	    	int num = Integer.parseInt(br.readLine());
	    	
	    	if (i % 2 == 0) {
	    		if (rightPq.isEmpty() != true && num > rightPq.peek()) {
	    			leftPq.add(rightPq.poll());
	    			rightPq.add(num);
	    		}
	    		
	    		else {
	    			leftPq.add(num);
	    		}
	    	}
	    	
	    	else {
	    		if (num < leftPq.peek()) {
	    			rightPq.add(leftPq.poll());
	    			leftPq.add(num);
	    		}
	    		
	    		else {
	    			rightPq.add(num);
	    		}
	    	}
	    	
	    	bw.write(leftPq.peek() + "\n");
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