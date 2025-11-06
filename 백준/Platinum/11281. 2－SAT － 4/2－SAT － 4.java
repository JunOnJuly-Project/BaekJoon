import java.io.*;
import java.util.*;

public class Main {
	int N;
	int M;
	int lastId;
	int lastGroup;
	
	int[] lo;
	int[] id;
	int[] group;
	
	List<List<Integer>> graph;
	
	Deque<Integer> stack;
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
	
	public int scc(int cur) {
		int curId = lastId++;
		id[cur] = curId;
		lo[cur] = curId;
		stack.add(cur);
		
		for (int next : graph.get(cur)) {
			if (id[next] == 0) {
				lo[cur] = Math.min(lo[cur], scc(next));
			}
			
			else if (group[next] == 0) {
				lo[cur] = Math.min(lo[cur], lo[next]);
			}
		}
		
		if (lo[cur] == id[cur]) {
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
	public int pos(int n) {
		return n > 0 ? n : N - n;
	}
	
	public int neg(int n) {
		return n > 0 ? N + n : -n;
	}
	
	public Map<Integer, List<Integer>> topologySort() {
		int len = 2 * N + 1;
		Map<Integer, List<Integer>> result = new HashMap<>();
		for (int i = 1; i < len; i++) {
			List<Integer> value = result.getOrDefault(group[i], new ArrayList<>());
			value.add(i);
			
			result.put(group[i], value);
		}
		
		return result;
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i < 2 * N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
	
			graph.get(neg(x)).add(pos(y));
			graph.get(neg(y)).add(pos(x));
		}
		
		lastId = 1;
		lastGroup = 1;
		
		lo = new int[2 * N + 1];
		id = new int[2 * N + 1];
		group = new int [2 * N + 1];
		stack = new LinkedList<>();
		
		for (int i = 1; i < 2 * N + 1; i++) {
			if (group[i] == 0) {
				scc(i);
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (group[i] == group[N + i]) {
				bw.write(0 + "");
				break;
			}
			
			else if (i == N) {
				bw.write(1 + "\n");
				
				boolean[] bool = new boolean[2 * N + 1];
				
				Map<Integer, List<Integer>> groups = topologySort();
				for (int key : groups.keySet()) {
					for (int node : groups.get(key)) {
						if (bool[node] == false) {
							bool[node > N ? node - N : node + N] = true;							
						}
					}
				}
				
				for (int j = 1; j < N + 1; j++) {
					bw.write(bool[j] ? "0 " : "1 ");
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}