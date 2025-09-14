import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	    int  n = Integer.parseInt(br.readLine());
	    
	    List<Integer> memo = new ArrayList<>();
	    memo.add(0);
	    memo.add(1);
	    memo.add(3);
	    
	    for (int i = 3; i <= n; i++) {
	    	memo.add((memo.get(i - 1) + memo.get(i - 2) * 2) % 10007);
	    }
	    
	    // 출력
	    bw.write(memo.get(n) + "");
	    br.close();
	    bw.flush();
	    bw.close();
	  }
	  
	  public static void main(String[] args) throws Exception {
	      new Main().solution();
	  }
}