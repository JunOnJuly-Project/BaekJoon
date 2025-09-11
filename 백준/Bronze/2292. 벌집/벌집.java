import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	    int N = Integer.parseInt(br.readLine());
	    int roomsIncludesLast = 0;
	    
	    int cnt = 0;
	    while (roomsIncludesLast < N) {
	    	if (cnt == 0) {
	    		roomsIncludesLast += 1;
	    		cnt += 1;
	    	}
	    	
	    	else {
	    		roomsIncludesLast += 6 * cnt;
	    		cnt += 1;
	    	}
	    }
	    
	    // 출력
	    bw.write(cnt + "");
	    br.close();
	    bw.flush();
	    bw.close();
	  }
	  
	  public static void main(String[] args) throws Exception {
	      new Main().solution();
	  }
}