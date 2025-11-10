import java.io.*;
import java.util.*;

public class Main {
	int N;
	int M;
	
	static int DEPTH = 20;
	
	List<List<Integer>> graph;
	List<int[]> rankedTree;
	int[][] sparseTable;
	
	public void rankTree() {
		rankedTree = new ArrayList<>();
		for (int i = 0; i < N + 1; i ++) {
			rankedTree.add(new int[2]);
		}
		
		boolean[] visited = new boolean[N + 1];
		Deque<int[]> queue = new LinkedList<>();
		queue.add(new int[] {1, 0});
		visited[1] = true;
		
		while (queue.isEmpty() == false) {
			int[] cur = queue.pollFirst();
			int curNode = cur[0];
			int curDepth = cur[1];
			
			
			for (int nextNode : graph.get(curNode)) {
				if (visited[nextNode] == false) {
					visited[nextNode] = true;
					queue.addLast(new int[] {nextNode, curDepth + 1});
					rankedTree.set(nextNode, new int[] {curNode, curDepth + 1});
				}
			}
		}
	}
	
	int[] setDepth(int node1, int node2) {
		int rank1 = rankedTree.get(node1)[1];
		int rank2 = rankedTree.get(node2)[1];
		
		if (rank1 == rank2) {
			return new int[] {node1, node2};
		}
		
		if (rank1 > rank2) {
			return setDepth(sparseTable[(int)Math.log(rank1 - rank2)][node1], node2);
		}
		
		else {
			return setDepth(node1, sparseTable[(int)Math.log(rank2 - rank1)][node2]);
		}
	}
	
	public void sparse() {
		sparseTable = new int[DEPTH + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			sparseTable[0][i] = rankedTree.get(i)[0];
		}
		
		for (int i = 1; i <= DEPTH; i++){
			for (int j = 0; j < N + 1; j++) {
				sparseTable[i][j] = sparseTable[i - 1][sparseTable[i - 1][j]];
			}
		}
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;	
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i ++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		M = Integer.parseInt(br.readLine());
		
		rankTree();
		sparse();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int[] setNode = setDepth(a, b);
			
			a = setNode[0];
			b = setNode[1];
			if (a == b) {
				bw.write(a + "\n");
			}
			
			else {
				for (int j = DEPTH; j >= 0; j--) {
					int nextA = sparseTable[j][a];
					int nextB = sparseTable[j][b];
					if (nextA != nextB) {
						a = nextA;
						b = nextB;
					}
				}
				
				bw.write(rankedTree.get(a)[0] + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}