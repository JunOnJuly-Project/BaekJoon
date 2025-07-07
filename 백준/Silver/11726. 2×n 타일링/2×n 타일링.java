import java.io.*;
import java.util.*;


public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        int[] memo = new int[1001];
        memo[1] = 1;
        memo[2] = 2;
        
        for (int i=3;i<1001;i++) {
        	memo[i] = (memo[i-1] + memo[i-2]) % 10007;
        }
        
        bw.write(memo[N]+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}