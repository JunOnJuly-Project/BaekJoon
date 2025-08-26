import java.util.*;
import java.io.*;

public class Main {
	public void solution() throws Exception {
		// 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        int[][] memo = new int [15][15];
        Arrays.setAll(memo[0], i -> i);
        for (int i = 1; i < 15; i++) {
        	for (int j = 1; j < 15; j++) {
        		for (int k = 1; k <= j; k++) {
        			memo[i][j] += memo[i - 1][k];
        		}
        	}
        }
        
        for (int t = 0; t < T; t++) {
        	int k = Integer.parseInt(br.readLine()); 
        	int n = Integer.parseInt(br.readLine()); 
        	
        	bw.write(memo[k][n] + "\n");
        }
        
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}