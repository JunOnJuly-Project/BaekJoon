import java.io.*;
import java.util.*;

public class Main {
	final int LOG = 20;
	final int ROOT = 1;
	
	int N;
	int Q;
	int target;
	int point;
	int length;
	int node1;
	int node2;
	
	int[] tree;
	int[] depth;
	
	int[][] sparseTable;
	
	List<List<Integer>> graph;
	
	public void setDepth() {
		tree = new int[N + 1];
		depth = new int[N + 1];
		
		depth[ROOT] = 1;
		Deque<int[]> queue = new LinkedList<>(Arrays.asList(new int[] {ROOT, 1}));
		Set<Integer> visited = new HashSet<>(Arrays.asList(ROOT));
		while (queue.isEmpty() == false) {
			int[] cur = queue.pollFirst();
			int curNode = cur[0];
			int curDepth = cur[1];
			int nextDepth = curDepth + 1;
			
			for (int nextNode : graph.get(curNode)) {
				if (visited.contains(nextNode) == false) {
					visited.add(nextNode);
					tree[nextNode] = curNode;	
					depth[nextNode] = nextDepth;
					
					queue.add(new int[] {nextNode, nextDepth});
				}
			}
		}
	}
	
	public void sparse() {
		sparseTable = new int[N + 1][LOG];
		
		for (int j = 0; j < LOG; j++) {
			for (int i = 0; i < N + 1; i++) {
				if (j == 0) {
					sparseTable[i][j] = tree[i];
				}
				
				else {
					sparseTable[i][j] = sparseTable[sparseTable[i][j - 1]][j - 1];
				}
			}
		}
	}
	
	public int flat() {
		int subLength = 0;
		
		if (depth[node1] < depth[node2]) {
			int temp = node1;
			node1 = node2;
			node2 = temp;
			
		}
		
		target = node1;
		
		for (int i = LOG - 1; i >= 0; i--) {
			if (1 << i <= depth[node1] - depth[node2]) {
				node1 = sparseTable[node1][i];
				
				subLength += 1 << i;
			}
		}
		
		return subLength;
	}
	
	public boolean lca() {
		int subLength = flat();
		
		if (subLength % 2 != 0) {
			return false;
		}
		
		for (int i = LOG - 1; i >= 0; i--) {
			int nextNode1 = sparseTable[node1][i];
			int nextNode2 = sparseTable[node2][i];
			if (nextNode1 != nextNode2) {
				node1 = nextNode1;
				node2 = nextNode2;
				
				subLength += 1 << (i + 1);
			}		
		}
		
		if (node1 != node2) {
			subLength += 2;			
		}
		
		if (subLength > length) {
			length = subLength;
			
			int halfLength = length / 2;
			for (int i = LOG - 1; i >= 0; i--) {
				if (1 << i <= halfLength) {
					halfLength -= 1 << i;
					target = sparseTable[target][i];
				}
			}
			
			point = target;
		}
		
		return true;
	}
	
	public int calDist(int node1, int node2) {
		int subLength = 0;
		
		if (depth[node1] < depth[node2]) {
			int temp = node1;
			node1 = node2;
			node2 = temp;
			
		}
		
		for (int i = LOG - 1; i >= 0; i--) {
			if (1 << i <= depth[node1] - depth[node2]) {
				node1 = sparseTable[node1][i];
				
				subLength += 1 << i;
			}
		}
		
		for (int i = LOG - 1; i >= 0; i--) {
			int nextNode1 = sparseTable[node1][i];
			int nextNode2 = sparseTable[node2][i];
			if (nextNode1 != nextNode2) {
				node1 = nextNode1;
				node2 = nextNode2;
				
				subLength += 1 << (i + 1);
			}		
		}
		
		if (node1 != node2) {
			subLength += 2;			
		}
		
		return subLength;
	}
	
	public boolean combNodes(int[] nodes) {
		int nodeLen = nodes.length;
		point = 0;
		length = -1;
		
		for (int i = 0; i < nodeLen - 1; i++) {
			for (int j = i + 1; j < nodeLen; j++) {
				node1 = nodes[i];
				node2 = nodes[j];
				
				if (lca() == false) {
					return false;
				}
			}
		}
		
		int targetLength = calDist(point, nodes[0]);
		for (int i = 1; i < 3; i++) {
			if (calDist(point, nodes[i]) != targetLength) {
				return false;
			}
		}
		
		return true;
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;	
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			graph.get(X).add(Y);
			graph.get(Y).add(X);
		}
		
		setDepth();
		sparse();
		
		Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			int[] nodes = new int[] {A, B, C};
			bw.write((combNodes(nodes) == true ? point : -1) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}