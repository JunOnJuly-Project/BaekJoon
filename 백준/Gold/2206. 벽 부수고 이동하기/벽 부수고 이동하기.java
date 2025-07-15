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
        
        String[] map = new String[N];
        for (int i=0;i<N;i++) map[i] = br.readLine();
        
        int[][][] dists = new int[2][N][M];
        for (int i=0;i<2;i++) for (int j=0;j<N;j++) for (int k=0;k<M;k++) dists[i][j][k] = Integer.MAX_VALUE;
        dists[0][0][0] = 1;
        
        PriorityQueue<int[]> hq = new PriorityQueue<int[]>((a, b)->a[0]-b[0]);
        hq.add(new int[] {1, 0, 0, 0});
        while (!hq.isEmpty()) {
        	int[] curArr = hq.poll();
        	int curDist = curArr[0];
        	int curI = curArr[1];
        	int curJ = curArr[2];
        	int breakCnt = curArr[3];
        	
        	if (curDist<dists[breakCnt][curI][curJ]) continue;
        	
        	for (int[] dir : new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}) {
        		int nextI = curI+dir[0];
        		int nextJ = curJ+dir[1];
        		
        		if ((nextI>=0 && nextI<N) && (nextJ>=0 && nextJ<M)) {
        			if (map[nextI].charAt(nextJ)=='0') {
        				if (curDist+1<dists[breakCnt][nextI][nextJ]) {
        					dists[breakCnt][nextI][nextJ] = curDist+1;
        					hq.add(new int[] {curDist+1, nextI, nextJ, breakCnt});
        				}
        			}
        				
    				else if (breakCnt==0) {
    					if (curDist+1<dists[breakCnt+1][nextI][nextJ]) {
        					dists[breakCnt+1][nextI][nextJ] = curDist+1;
        					hq.add(new int[] {curDist+1, nextI, nextJ, breakCnt+1});
        				}
        			}
        		}
        	}
        }
        
        int nonBreakMin = dists[0][N-1][M-1];
        int breakMin = dists[1][N-1][M-1];
        
        if (nonBreakMin==Integer.MAX_VALUE && breakMin==Integer.MAX_VALUE) bw.write(-1+"");
        else bw.write(Math.min(nonBreakMin, breakMin)+"");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}