import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++) {
        	int n = Integer.parseInt(br.readLine());
        	
        	int[][] nums = new int[n][2];
        	for (int j=0;j<2;j++) {
        		st = new StringTokenizer(br.readLine());
        		for (int k=0;k<n;k++) {
        			nums[k][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	int[][] memo = new int[n+1][2];
        	memo[1][0] = nums[0][0];
        	memo[1][1] = nums[0][1];
        	for (int j=2;j<n+1;j++) {
        		memo[j][0] = Arrays.stream(new int[] {memo[j-1][1], memo[j-2][1]}).max().getAsInt() + nums[j-1][0];
        		memo[j][1] = Arrays.stream(new int[] {memo[j-1][0], memo[j-2][0]}).max().getAsInt() + nums[j-1][1];
        	}
        	
        	int max = 0;
        	for (int[] mem : memo) for (int m : mem) max = m>max ? m : max;
        	
        	bw.write(max + "\n");
        }
       
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}