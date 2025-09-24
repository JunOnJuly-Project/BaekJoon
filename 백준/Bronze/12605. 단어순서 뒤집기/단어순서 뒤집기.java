import java.io.*;
import java.util.*;

public class Main {	
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	while(st.hasMoreTokens()) {
        		stack.push(st.nextToken());
        	}
        	
        	bw.write(String.format("Case #%d:", i + 1));
        	while (stack.isEmpty() == false) {
        		bw.write(String.format(" %s", stack.pop()));
        	}
        	bw.write("\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}