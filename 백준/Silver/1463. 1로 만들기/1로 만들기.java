import java.io.*;
import java.util.*;


public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        Deque<Integer[]> dq = new LinkedList<>();
        dq.addLast(new Integer[] {N, 0});        
        while (true){
            Integer[] nums = dq.pollFirst();
            int num = nums[0];
            int cnt = nums[1];
            
            if (num == 1) {
            	bw.write(cnt+"");
            	break;
            }
            
            if (num%3 == 0) {
            	dq.addLast(new Integer[] {num/3, cnt+1});
            }
            
            if (num%2 == 0) {
            	dq.addLast(new Integer[] {num/2, cnt+1});
            }
            
            dq.addLast(new Integer[] {num-1, cnt+1});
        }
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}