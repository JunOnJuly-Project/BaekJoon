import java.io.*;
import java.util.*;


public class Main {
	public int[] dijkstra(List<List<int[]>> tree, int X, int N) throws Exception {
		int[] dists = new int[N+1];
		Arrays.setAll(dists, i->Integer.MAX_VALUE);
		dists[X] = 0;
		
		PriorityQueue<int[]> hq = new PriorityQueue<int[]>((a, b)->a[1]-b[1]);
		hq.add(new int[] {X, 0});
		while (!hq.isEmpty()) {
			int[] curArr = hq.poll();
			int curNode = curArr[0];
			int curDist = curArr[1];
			
			if (dists[curNode]>curDist) continue;
			
			for (int[] nextArr : tree.get(curNode)) {
				int nextNode = nextArr[0];
				int nextDist = curDist+nextArr[1];
				
				if (nextDist<dists[nextNode]) {
					dists[nextNode] = nextDist;
					hq.add(new int[] {nextNode, nextDist});
				}
			}
		}
		
		return dists;
	}
	
	
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N, M, X;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<List<int[]>> tree = new ArrayList<>();
        List<List<int[]>> reversedTree = new ArrayList<>();
        for (int i=0;i<N+1;i++) {
        	tree.add(new ArrayList<>());
        	reversedTree.add(new ArrayList<>());
        }
        
        for (int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int s, e, t;
        	s = Integer.parseInt(st.nextToken());
        	e = Integer.parseInt(st.nextToken());
        	t = Integer.parseInt(st.nextToken());
        	
        	tree.get(s).add(new int[] {e, t});
        	reversedTree.get(e).add(new int[] {s, t});
        }
        
        int[] fromX = dijkstra(tree, X, N);
        int[] toX = dijkstra(reversedTree, X, N);
        int[] totalDist = new int[N+1];
        Arrays.setAll(totalDist, i->i==0 ? 0 : fromX[i]+toX[i]);
        
        bw.write(Arrays.stream(totalDist).max().getAsInt()+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}