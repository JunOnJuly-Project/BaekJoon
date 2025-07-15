import java.io.*;
import java.util.*;


public class Main {
	public boolean canPlace(boolean[][] board, int idx[], int N) throws Exception {
		int i = idx[0];
		int j = idx[1];
		
		for (int ii=0;ii<N;ii++) {
			if (board[i][ii]) return false;
		}
		
		for (int jj=0;jj<N;jj++) {
			if (board[jj][j]) return false;
		}
		
		int lti = i-j;
		int lbi = i+j;
		
		int ii = 0;
		int jj;
		while (ii<N) {
			jj = ii-lti;
			if (jj>=0 && jj<N) if (board[ii][jj]) return false;
			
			jj = lbi-ii;
			if (jj>=0 && jj<N) if (board[ii][jj]) return false;
			
			ii++;
		}
		
		return true;
	}
	
	
	public int queen(boolean[][] board, int i, int N) throws Exception {
		if (i==N) return 1;
		
		int result = 0;
		for (int j=0;j<N;j++) {
			if (canPlace(board, new int[] {i, j}, N)) {
				board[i][j] = true;
				result += queen(board, i+1, N);
			}
			
			board[i][j] = false;
		}
		
		return result;
	}
	
	
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());

        boolean[][] board = new boolean[N][N];
        
        bw.write(queen(board, 0, N)+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}