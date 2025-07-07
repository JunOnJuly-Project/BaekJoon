import java.io.*;
import java.util.*;


public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t=0;t<T;t++) {
	        st = new StringTokenizer(br.readLine());
	        int N, M, K;
	        M = Integer.parseInt(st.nextToken());
	        N = Integer.parseInt(st.nextToken());
	        K = Integer.parseInt(st.nextToken());
	        
	        boolean[][] map = new boolean[N][M];
	        for (int i=0;i<K;i++) {
	        	st = new StringTokenizer(br.readLine());
	        	int x, y;
	        	x = Integer.parseInt(st.nextToken());
	        	y = Integer.parseInt(st.nextToken());
	        	
	        	map[y][x] = true;
	        }
	        
	        int[][] dirs = new int[][] {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
	        int result = 0;
	        for (int i=0;i<N;i++) {
	        	for (int j=0;j<M;j++) {
	        		if (map[i][j]) {
	        			result += 1;
	        			Deque<int[]> dq = new LinkedList<>();
	        			dq.addLast(new int[] {i, j});
	        			
	        			while(!dq.isEmpty()) {
	        				int[] idx = dq.pollFirst();
	        				int x, y;
	        				x = idx[1];
	        				y = idx[0];
	        				
	        				for (int[] dir : dirs) {
	        					int dx = dir[1];
	        					int dy = dir[0];
	        					
	        					int nx = x + dx;
	        					int ny = y + dy;
	        					
	        					if ((nx>=0 && nx<M) && (ny>=0 && ny<N) && (map[ny][nx])) {
	        						map[ny][nx] = false;
	        						dq.addLast(new int[] {ny, nx});
	        					}
	        				}
	        			}
	        		}
	        	}
	        }
	        bw.write(result+ "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}