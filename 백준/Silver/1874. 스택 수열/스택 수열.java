import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	    int  n = Integer.parseInt(br.readLine());
	    Deque<Integer> stk = new LinkedList<>();
	    List<String> result = new ArrayList<>();
	    
	    int last = 1;
	    for (int i = 0; i < n; i++) {
	    	int num = Integer.parseInt(br.readLine());
	    	if (num >= last) {
	    		
	    		for (int j = last; j <= num; j++) {
	    			stk.addLast(j);
	    			result.add("+");
	    		}
	    		
	    		last = num + 1;
	    		
	    		stk.pollLast();
	    		result.add("-");
	    	}
	    	
	    	else if (num == stk.peekLast()) {
	    		stk.pollLast();
	    		result.add("-");
	    	}
	    	
	    	else {
	    		bw.write("NO");
	    		break;
	    	}
	    }
	    
	    if (result.size() == 2 * n) {
	    	for (String s : result ) {
	    		bw.write(s + "\n");
	    	}
	    }
	    
	    br.close();
	    bw.flush();
	    bw.close();
	  }
	  
	  public static void main(String[] args) throws Exception {
	      new Main().solution();
	  }
}