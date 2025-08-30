import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int K = Integer.parseInt(br.readLine());
        
        Deque<Integer> stk = new LinkedList<>();
        for (int i = 0; i < K; i++) {
        	int num = Integer.parseInt(br.readLine());
        	
        	if (num == 0) {
        		stk.pollLast();
        	}
        	
        	else {
        		stk.addLast(num);
        	}
        }
        
        int sum = 0;
        for (int num : stk) {
        	sum += num;
        }
        
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}