import java.io.*;
import java.util.*;


public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        int[] memo = new int[11];
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;
        
        for (int i=4;i<11;i++) {
        	for (int j=1;j<=3;j++) {
        		memo[i] += memo[i-j];
        	}
        }
        
        for (int i=0;i<T;i++) {
        	int n = Integer.parseInt(br.readLine());
        	bw.write(memo[n] + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}