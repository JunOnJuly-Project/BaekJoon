import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    while (true) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	
	    	int a, b;
	    	a = Integer.parseInt(st.nextToken());
	    	b = Integer.parseInt(st.nextToken());
	    	
	    	if (a == 0 && b == 0) {
	    		break;
	    	}
	    	
	    	if (b % a == 0) {
	    		bw.write("factor\n");
	    	}
	    	
	    	else if (a % b == 0) {
	    		bw.write("multiple\n");
	    	}
	    	
	    	else {
	    		bw.write("neither\n");
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