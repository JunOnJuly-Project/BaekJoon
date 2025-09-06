import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N, K;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
        	dq.add(i);
        }
        
        bw.write("<");
        
        while (dq.isEmpty() != true) {
        	for (int i = 0; i < K - 1; i++) {
        		dq.add(dq.pollFirst());
        	}
        	
        	bw.write(dq.pollFirst() + "");
        	
        	if (dq.isEmpty() != true) {
        		bw.write(", ");
        	}
        }
        
        bw.write(">");
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}