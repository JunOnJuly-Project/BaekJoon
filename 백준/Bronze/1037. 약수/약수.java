import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
        List<Integer> nums = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
	    
        int max = Collections.max(nums);
        int min = Collections.min(nums);
        		
	    bw.write(max * min + "");
	    // 출력
	    br.close();
	    bw.flush();
	    bw.close();
	  }
	  
	  public static void main(String[] args) throws Exception {
	      new Main().solution();
	  }
}