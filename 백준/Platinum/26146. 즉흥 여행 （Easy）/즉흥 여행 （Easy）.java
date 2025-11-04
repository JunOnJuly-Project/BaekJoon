import java.io.*;
import java.util.*;

public class Main {
	int N;
	int M;
	int lastGroup = 1;
	int lastId = 1;
	
	int[] ids;
	int[] group;
	
	List<List<Integer>> graph = new ArrayList<>();
	
	Deque<Integer> stack = new LinkedList<>();
	
	public int scc(int cur) throws Exception {
		int curId = lastId++;
		ids[cur] = curId;
		
		stack.addLast(cur);
		
		for (int next : graph.get(cur)) {
			if (ids[next] == 0) {
				ids[cur] = Math.min(ids[cur], scc(next));
			}
			
			else if (group[next] == 0) {
				ids[cur] = Math.min(ids[cur], ids[next]);
			}
		}
		
		if (curId == ids[cur]) {
			while (true) {
				int pop = stack.pollLast();
				group[pop] = lastGroup;
				
				if (pop == cur) {
					lastGroup += 1;
					break;
				}
			}
		}
		
		return ids[cur];
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ids = new int[N + 1];
		group = new int[N + 1];
		
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int v, w;
			v =  Integer.parseInt(st.nextToken());
			w =  Integer.parseInt(st.nextToken());
			
			graph.get(v).add(w);
		}
		
		for (int i = 1; i < N + 1; i++) {
			if (ids[i] == 0) {
				scc(i);
			}
		}

		br.close();
		bw.write(lastGroup == 2 ? "Yes" : "No");
		bw.flush();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}