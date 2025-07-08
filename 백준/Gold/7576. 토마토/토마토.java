import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M, N;
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        Deque<int[]> dq = new LinkedList<>();

        int[][] board = new int[N][M];
        for (int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0;j<M;j++) {
        		int num = Integer.parseInt(st.nextToken());
        		board[i][j] = num;
        		
        		if (num==1) dq.addLast(new int[] {i, j, 0});
        	}
        }
        
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        int minDate = 0;
        while (!dq.isEmpty()) {
        	int[] nowArr = dq.pollFirst();
        	int nowI = nowArr[0];
        	int nowJ = nowArr[1];
        	int nowD = nowArr[2];
        	
        	minDate = nowD>minDate ? nowD : minDate;
        	
        	for (int[] dir : dirs) {
        		int di = dir[0];
        		int dj = dir[1];
        		
        		int nextI = nowI+di;
        		int nextJ = nowJ+dj;
        		if ((nextI>=0 && nextI<N) && (nextJ>=0 && nextJ<M) && board[nextI][nextJ]==0) {
        			board[nextI][nextJ] = 1;
        			dq.addLast(new int[] {nextI, nextJ, nowD+1});
        		}
        	}
        }
        
        int state = minDate;
        for (int i=0;i<N;i++) for (int j=0;j<M;j++) if (board[i][j]==0) state = -1;
        
        bw.write(state+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}