import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int a, b;
	    a = Integer.parseInt(st.nextToken());
	    b = Integer.parseInt(st.nextToken());
	    
	    Deque<int[]> queue = new LinkedList<>();
	    queue.add(new int[] {a, 1});
	    
	    while (true) {
	    	if (queue.isEmpty()) {
	    		bw.write(-1 + "");
	    		break;
	    	}
	    	
	    	int[] cur = queue.pollFirst();
	    	int curNum = cur[0];
	    	int curCnt = cur[1];
	    	
	    	if (curNum == b) {
	    		bw.write(curCnt + "");
	    		break;
	    	}
	    	
	    	long doubleCurNum = curNum * 2;
	    	
	    	if (doubleCurNum <= b) {
	    		queue.addLast(new int[] {(int) doubleCurNum, curCnt + 1});
	    	}
	    	
	    	long addedCur = Long.parseLong(Integer.toString(curNum) + 1);
	    	
	    	if (addedCur <= b) {
	    		queue.addLast(new int[] {(int) addedCur, curCnt + 1});
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