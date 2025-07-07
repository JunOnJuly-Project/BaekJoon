import java.io.*;
import java.util.*;


public class Main {
	public int[] reculSol(int[][] board, int si, int ei, int sj, int ej) {
		int state = -1;
		int white = 0;
		int blue = 0;

		for (int i=si;i<ei;i++) {
			for (int j=sj;j<ej;j++) {
				if (state==-1) state = board[i][j];
				else if (state!=board[i][j]) {
					int mi = (si+ei)/2;
					int mj = (sj+ej)/2;
					
					int[] is = new int[] {si, mi, ei};
					int[] js = new int[] {sj, mj, ej};
					for (int k=0;k<2;k++) {
						for (int l=0;l<2;l++) {
							int[] wb = reculSol(board, is[k], is[k+1], js[l], js[l+1]);
							white += wb[0];
							blue += wb[1];
						}
					}
					
					return new int[] {white, blue};
				}
			}
		}
		
		if (state==0) white += 1;
		else blue += 1;
		
		return new int[] {white, blue};
	}
	
	
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0;j<N;j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }

        int[] result = reculSol(board, 0, N, 0, N);
        bw.write(result[0] + "\n");
        bw.write(result[1] + "\n");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}