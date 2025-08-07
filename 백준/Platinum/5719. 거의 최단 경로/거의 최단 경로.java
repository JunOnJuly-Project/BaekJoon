import java.util.*;
import java.io.*;

public class Main {
	public int dijkstra(int[][] graph, int start, int end) {
		int graphLen = graph.length;
		
		int[] minDists = new int[graphLen];
		Arrays.fill(minDists, Integer.MAX_VALUE);
		minDists[start] = 0;
		
		List<List<Integer>> visited = new ArrayList<List<Integer>>();
		for (int i = 0; i < graphLen; i++) {
			visited.add(new ArrayList<Integer>());
		}
		
		PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
		heap.add(new int[] {start, 0});
		
		while (heap.isEmpty() != true) {
			int[] cur = heap.poll();
			int curNode = cur[0];
			int curDist = cur[1];
			
			if (curDist > minDists[curNode]) {
				continue;
			}
			
			for (int nextNode = 0; nextNode < graphLen; nextNode++) {
				int dist = graph[curNode][nextNode];
				
				if (dist == 0) {
					continue;
				}
				
				int nextDist = dist + curDist;
				
				if (nextDist < minDists[nextNode]) {
					visited.set(nextNode, new ArrayList<Integer>());
					visited.get(nextNode).add(curNode);
					
					minDists[nextNode] = nextDist;
					
					heap.add(new int[] {nextNode, nextDist});
				}
				
				else if (nextDist == minDists[nextNode]) {
					visited.get(nextNode).add(curNode);
				}
			}
		}
		
		Deque<Integer> stk = new LinkedList<Integer>();
		stk.add(end);
		
		while (stk.isEmpty() != true) {
			int e = stk.getLast();
			int visitLen = visited.get(e).size();
			
			if (visitLen == 0) {
				stk.pollLast();
				continue;
			}
			
			for (int i = 0; i < visitLen; i++) {
				int s = visited.get(e).get(i);
				
				if (graph[s][e] != 0) {
					graph[s][e] = 0;
					stk.add(s);
					break;
				}
				
				else if (i == visitLen - 1) {
					stk.pollLast();
				}
			}
		}
		
		return minDists[end];
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N, M;
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if (N == 0) {
				break;
			}
			
			st = new StringTokenizer(br.readLine());
			int S, D;
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			int[][] graph = new int[N][N];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int U, V, P;
				U = Integer.parseInt(st.nextToken());
				V = Integer.parseInt(st.nextToken());
				P = Integer.parseInt(st.nextToken());
				
				graph[U][V] = P;
			}
			
			dijkstra(graph, S, D);
			int result = dijkstra(graph, S, D);
			if (result == Integer.MAX_VALUE) {
				result = -1;
			}
			
			bw.write(result + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}