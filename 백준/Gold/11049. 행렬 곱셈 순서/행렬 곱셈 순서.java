import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] row = new int[N];
        int[] col = new int[N];
        for (int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	row[i] = Integer.parseInt(st.nextToken());
        	col[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][]memo = new int[N][N];
        for (int i=0;i<N;i++) {
        	Arrays.setAll(memo[i], j->Integer.MAX_VALUE);
        	memo[i][i] = 0;
        }
        
        for (int i=1;i<N;i++) {
	        for (int j=0;j<N-i;j++) {
	        	for (int k=0;k<i;k++) {
	        		memo[j][j+i] = Math.min(memo[j][j+i], memo[j][j+k] + memo[j+k+1][j+i] + row[j]*col[j+k]*col[j+i]);	        		
	        	}
	        }
        }
        
        bw.write(memo[0][N-1]+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}