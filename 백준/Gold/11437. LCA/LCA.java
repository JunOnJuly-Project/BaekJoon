import java.io.*;
import java.util.*;

public class Main {
	int N;
	int M;
	
	List<List<Integer>> graph;
	List<int[]> rankedTree;
	
	public void rankTree() {
		rankedTree = new ArrayList<>();
		for (int i = 0; i < N + 1; i ++) {
			rankedTree.add(new int[2]);
		}
		
		boolean[] visited = new boolean[N + 1];
		Deque<int[]> queue = new LinkedList<>();
		queue.add(new int[] {1, 1});
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
			return setDepth(rankedTree.get(node1)[0], node2);
		}
		
		else {
			return setDepth(node1, rankedTree.get(node2)[0]);
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
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int[] setNode = setDepth(a, b);
			
			a = setNode[0];
			b = setNode[1];
			
			while(a != b) {
				a = rankedTree.get(a)[0];
				b = rankedTree.get(b)[0];
			}
			
			bw.write(a + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}