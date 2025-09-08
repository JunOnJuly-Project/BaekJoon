import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int T = Integer.parseInt(br.readLine());
	    
	    for (int i = 0; i < T; i++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	bw.write("Case " + (i + 1) + ": " + 
	    			(
	    					Integer.parseInt(st.nextToken()) + 
	    					Integer.parseInt(st.nextToken())) + "\n"
	    			);
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