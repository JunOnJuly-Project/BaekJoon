import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] memo = new int[13];
        Arrays.fill(memo, 1);
        
        for (int i = 1; i < 13; i++) {
            memo[i] *= memo[i - 1] * i;
        }
        
        bw.write(memo[N] + "");
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}