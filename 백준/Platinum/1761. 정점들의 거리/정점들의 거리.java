import java.io.*;
import java.util.*;

public class Main {
	final int LOG = 20;
	final int ROOT = 1;
	
	int N;
	int M;
	
	List<List<int[]>> graph;
	int[] tree;
	int[] costs;
	int[] depth;
	
	int[][] sparseTable;
	int[][] costSparseTable;
	
	public void setTree () {
		Deque<int[]> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		queue.add(new int[] {ROOT, 1});
		visited.add(ROOT);
		depth[ROOT] = 1;
		
		while (queue.isEmpty() == false) {
			int[] cur = queue.pollFirst();
			int curNode = cur[0];
			int curDepth = cur[1];
			int nextDepth = curDepth + 1;
			
			for (int[] next : graph.get(curNode)) {
				int nextNode = next[0];
				int curCost = next[1];
				
				if (visited.contains(nextNode) == false) {
					visited.add(nextNode);
					queue.add(new int[] {nextNode, nextDepth});
					
					tree[nextNode] = curNode;
					costs[nextNode] = curCost;
					depth[nextNode] = nextDepth;
				}
			}
		}
	}
	
	public void sparse() {
		for (int i = 1; i < N + 1; i ++) {
			sparseTable[i][0] = tree[i];
			costSparseTable[i][0] = costs[i];
		}
		
		for (int j = 1; j < LOG; j ++) {
		    for (int i = 1; i <= N; i ++) {
				sparseTable[i][j] = sparseTable[sparseTable[i][j - 1]][j - 1];
				costSparseTable[i][j] = 
						costSparseTable[i][j - 1] + 
						costSparseTable[sparseTable[i][j - 1]][j - 1];
			}
		}
	}
	
	public int[] sameDepth(int n1, int n2) {
		int cost = 0;
		
		int d1 = depth[n1];
		int d2 = depth[n2];

		if (d1 < d2) {
			return sameDepth(n2, n1);
		}
		
		for (int i = LOG - 1; i >= 0; i --) {
			int nextN1 = sparseTable[n1][i];
			
			if (depth[nextN1] >= d2) {
				int costN1 = costSparseTable[n1][i];
				cost += costN1;
				
				n1 = nextN1;
			}
		}
		
		return new int[] {n1, n2, cost};
	}
	
	public int lca(int n1, int n2) {
		int[] preSet = sameDepth(n1, n2);
		n1 = preSet[0];
		n2 = preSet[1];
		int cost = preSet[2];
		
		for (int i = LOG - 1; i >= 0; i --) {
			int nextN1 = sparseTable[n1][i];
			int nextN2 = sparseTable[n2][i];
			
			if (nextN1 != nextN2) {
				int costN1 = costSparseTable[n1][i];
				int costN2 = costSparseTable[n2][i];
				
				cost += costN1 + costN2;
				
				n1 = nextN1;
				n2 = nextN2;
			}
		}
		
		if (n1 != n2) {
			cost += costs[n1] + costs[n2];
		}
		
		return cost;
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;	
		
		N = Integer.parseInt(br.readLine());
		tree = new int[N + 1];
		costs = new int[N + 1];
		depth = new int[N + 1];
		sparseTable = new int[N + 1][LOG];
		costSparseTable = new int[N + 1][LOG];
		
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i ++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N - 1; i ++) {
			st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			graph.get(n1).add(new int[] {n2, d});
			graph.get(n2).add(new int[] {n1, d});
		}
		
		setTree();
		sparse();
		
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n1;
			int n2;
			
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			
			bw.write(lca(n1, n2) + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}