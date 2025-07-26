import java.io.*;
import java.util.*;


public class Main {
	public boolean isPalin(int[] nums, int s, int e) {
		int len = (e-s+1)/2;
		for (int i=0;i<len;i++) {
			if (nums[s+i-1]!=nums[e-i-1]) return false;
		}
		
		return true;
	}
	
	
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) nums[i] = Integer.parseInt(st.nextToken());
        
        boolean[][] memo = new boolean[N+1][N+1];
        for (int i=1;i<N+1;i++) memo[i][i] = true;
        
        for (int i=1;i<N+1;i++) {
        	for (int j=i+1;j<N+1;j++) {
        		if (i>1 && j<N && memo[i-1][j+1]) memo[i][j] = true;
        		else if (isPalin(nums, i, j)) {
        			memo[i][j] = true;
        		}
        	}
        }
        
        int M = Integer.parseInt(br.readLine());
        for (int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int S = Integer.parseInt(st.nextToken());
        	int E = Integer.parseInt(st.nextToken());
        	
        	bw.write(memo[S][E]? 1 + "\n" : 0 + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}