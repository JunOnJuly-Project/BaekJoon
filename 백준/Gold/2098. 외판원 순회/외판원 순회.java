import java.util.*;
import java.io.*;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] dists = new int[N][N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<N;j++) dists[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][] visited = new int[N][1<<N];
		for (int i=0;i<N;i++) Arrays.fill(visited[i], Integer.MAX_VALUE/2);
		for (int i=0;i<N;i++) visited[i][0] = 0;
		for (int i=0;i<N;i++) visited[i][1<<i] = 0;

		Deque<int[]> dq = new LinkedList<>();
		dq.add(new int[] {0, 0, 1<<0});			

		while (!dq.isEmpty()) {
			int[] cur = dq.pollFirst();
			int curNode = cur[0];
			int curDist = cur[1];
			int curVisitedNode = cur[2];
			
			if (curDist > visited[curNode][curVisitedNode]) {
				continue;
			}
			
			for (int nextNode=0;nextNode<N;nextNode++) {
				if (dists[curNode][nextNode]!=0 && (curVisitedNode&(1<<nextNode))==0) {
					int nextDist = curDist+dists[curNode][nextNode];
					int nextVisitedNode = curVisitedNode|(1<<nextNode);

					if (nextDist<visited[nextNode][nextVisitedNode]){
						visited[nextNode][nextVisitedNode] = nextDist;
						dq.add(new int[] {nextNode, nextDist, nextVisitedNode});
					}
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int i=1;i<N;i++) {
			if (dists[i][0] == 0) {
				continue;
			}
			
			min = Math.min(min, visited[i][(1<<N)-1] + dists[i][0]);
		}
		
		bw.write(min + "");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}