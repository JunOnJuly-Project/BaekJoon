import java.io.*;
import java.util.*;


public class Main {
	public int[][] moveDir(int[][] map, int[] dir, int N) throws Exception {
		int[] is;
		int[] js;
		
		if (dir[0]==1) {
			is = new int[N];
			Arrays.setAll(is, i->N-1-i);
		}
		else {
			is = new int[N];
			Arrays.setAll(is, i->i);
		}
		
		if (dir[1]==1){
			js = new int[N];
			Arrays.setAll(js, i->N-1-i);
		}
		else {
			js = new int[N];
			Arrays.setAll(js, i->i);
		}
		
		boolean[][] visited = new boolean[N][N];
		
		for (int i : is) {
			for (int j : js) {
				if (map[i][j]==0) continue;
				
				int beforeI;
				int beforeJ;
				int curI = i;
				int curJ = j;
				while (true) {
					beforeI = curI;
					beforeJ = curJ;
					curI += dir[0];
					curJ += dir[1];
					
					if ((curI>=0 && curI<N) && (curJ>=0 && curJ<N)) {
						if (map[curI][curJ]==0) {
							map[curI][curJ] = map[beforeI][beforeJ];
							map[beforeI][beforeJ] = 0;
							continue;
						}
						
						else if (map[curI][curJ]==map[beforeI][beforeJ] && !visited[curI][curJ]) {
							map[curI][curJ] = map[curI][curJ] * 2;
							map[beforeI][beforeJ] = 0;
							visited[curI][curJ] = true;
							break;
						}
						
						else break;
					}
					
					else break;
				}
			}
		}
		
		return map;
	}
	
	
	public int game(int[][] map, int N, int cnt) throws Exception {
		if (cnt>=5) {
			int max = 0;
			for (int i=0;i<N;i++) max = Math.max(max, Arrays.stream(map[i]).max().getAsInt());
			
			return max;
		}
		
		int maxValue = 0;
		for (int[] dir : new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
			int[][] copyMap = new int[N][N];
			for (int k=0;k<N;k++) copyMap[k] = map[k].clone();
			
			maxValue = Math.max(maxValue, game(moveDir(copyMap, dir, N), N, cnt+1));
		}
		
		return maxValue;
	}
	
	
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] map = new int[N][N];
        for (int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        
        int maxValue = game(map, N, 0);
        
        bw.write(maxValue+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}