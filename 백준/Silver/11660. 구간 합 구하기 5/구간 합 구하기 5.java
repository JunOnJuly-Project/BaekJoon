import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[N+1][N+1];
        for (int i=1;i<N+1;i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=1;j<N+1;j++) board[i][j] = Integer.parseInt(st.nextToken());
        }
        
        for (int i=1;i<N+1;i++) for (int j=1;j<N+1;j++) board[i][j] += board[i][j-1];
        for (int i=1;i<N+1;i++) for (int j=1;j<N+1;j++) board[i][j] += board[i-1][j];
        
        for (int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int si, ei, sj, ej;
        	si = Integer.parseInt(st.nextToken());
        	sj = Integer.parseInt(st.nextToken());
        	ei = Integer.parseInt(st.nextToken());
        	ej = Integer.parseInt(st.nextToken());
        	
        	int result = board[ei][ej] - board[ei][sj-1] - board[si-1][ej] + board[si-1][sj-1];
        	
        	bw.write(result + "\n");
        }
        				
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}