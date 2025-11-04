import java.io.*;
import java.util.*;

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	StringTokenizer st;
	
	int N;
	int min = Integer.MAX_VALUE;
	int edgeLen;
	int lastGroup;
	int lastId;
	int l = 0;
	int r = 0;
	
	int[] lo;
	int[] id;
	int[] group;
	
	List<int[]> edges = new ArrayList<>();
	
	Deque<Integer> stack;
	
	public int scc (int cur) {
		int curId = lastId++;
		id[cur] = curId;
		lo[cur] = curId;
		stack.add(cur);
		
		for (int i = l; i < r + 1; i++) {
			int[] edge = edges.get(i);
			
			if (edge[0] == cur) {
				int next = edge[1];
				
				if (id[next] == 0) {
					lo[cur] = Math.min(scc(next), lo[cur]);
				}
				
				else if (group[next] == 0) {
					lo[cur] = Math.min(lo[next], lo[cur]);
				}
			}
		}
		
		if (curId == lo[cur]) {
			while (true) {
				int pop = stack.pollLast();
				group[pop] = lastGroup;
				
				if (pop == cur) {
					lastGroup += 1;
					break;
				}
			}
		}
		
		return lo[cur];
	}
	
	public void solution() throws Exception {
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int weight =  Integer.parseInt(st.nextToken());
				edges.add(new int[] {i, j, weight});
			}
		}
		
		edgeLen = edges.size();
		
		edges.sort((a, b) -> a[2] - b[2]);
		
		while (l <= r && r < edgeLen) {
			lastGroup = 1;
			lastId = 1;
			
			lo = new int[N];
			id = new int[N];
			group = new int[N];
			stack = new LinkedList<>();
			
			for (int i = 0; i < N;  i++) {
				if (id[i] == 0) {
					scc(i);
				}
			}
			
			if (lastGroup > 2) {
				r += 1;
			}
			
			else {
				min = Math.min(edges.get(r)[2] - edges.get(l)[2], min);
				l += 1;
			}
		}
		
		br.close();
		bw.write(min + "");
		bw.flush();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}