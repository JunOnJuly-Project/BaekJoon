import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[n][m];
        int[][] result = new int[n][m];
        
        int si = 0;
        int sj = 0;
        for (int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0;j<m;j++) {
        		int num = Integer.parseInt(st.nextToken());
        		board[i][j] = num;
        		
        		if (num==0 || num==2) result[i][j] = 0;
        		else result[i][j] = -1;
        		
        		if (num==2) {
        			si = i;
        			sj = j;
        		}
        	}
        }
        
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        Deque<int[]> dq = new LinkedList<>();
        dq.addLast(new int[] {si, sj, 0});
        while (!dq.isEmpty()) {
        	int[] now = dq.pollFirst();
        	int i = now[0];
        	int j = now[1];
        	int c = now[2];
        	
        	for (int[] dir : dirs) {
        		int di = dir[0];
        		int dj = dir[1];
        		
        		int ii = i+di;
        		int jj = j+dj;
        		if ((ii>=0 && ii<n) && (jj>=0 && jj<m) && board[ii][jj]==1 && result[ii][jj]==-1) {
        			result[ii][jj] = c+1;
        			dq.addLast(new int[] {ii, jj, c+1});
        		}
        	}
        }
        
        for (int i=0;i<n;i++) {
        	for (int j=0;j<m;j++) {
        		bw.write(result[i][j] + " ");
        	}
        	bw.write("\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}