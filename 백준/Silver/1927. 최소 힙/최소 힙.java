import java.io.*;
import java.util.*;


public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> h = new PriorityQueue<>();
        for (int i=0;i<N;i++) {
        	int num = Integer.parseInt(br.readLine());
        	
        	if (num==0) {
        		if (h.isEmpty()) bw.write(0 + "\n");
        		else bw.write(h.poll() + "\n");
        	}
        	
        	else h.offer(num);
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}