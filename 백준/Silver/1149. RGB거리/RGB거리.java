import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N;
        N = Integer.parseInt(br.readLine());
        
        int[][] costs = new int[N][3];
        for (int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0;j<3;j++) costs[i][j] = Integer.parseInt(st.nextToken());
        }
        
        int[][] memo = new int[N][3];
        for (int i=0;i<N;i++) for (int j=0;j<3;j++) memo[i][j] = 1000000;
        for (int i=0;i<3;i++) memo[0][i] = costs[0][i];
        
        for (int i=1;i<N;i++) {
        	for (int j=0;j<3;j++) {
        		for (int k=0;k<3;k++) {
        			if (k != j) {
        				int candid = memo[i-1][k] + costs[i][j];
        				memo[i][j] = candid<memo[i][j] ? candid : memo[i][j];
        			}
        		}
        	}
        }
        
        int min = 1000000;
        for (int i=0;i<3;i++) {
        	int candid = memo[N-1][i];
        	min = candid<min ? candid : min;
        }
        
        bw.write(min+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}