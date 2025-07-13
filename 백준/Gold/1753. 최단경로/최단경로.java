import java.io.*;
import java.util.*;


public class Main {
	public int[] dijkstra(List<List<int[]>> tree, int K, int V) throws Exception {
		int[] costs = new int[V+1];
		Arrays.setAll(costs, i->3000000);
		costs[K] = 0;
		
		PriorityQueue<int[]> hq = new PriorityQueue<>((a, b)->a[0]-b[0]);
		hq.add(new int[] {0, K});
		
		while (!hq.isEmpty()) {
			int[] curArr = hq.poll();
			int curCost = curArr[0];
			int curNode = curArr[1];
			
			if (curCost>costs[curNode]) continue;
			
			for (int[] node : tree.get(curNode)) {
				int nextNode = node[0];
				int cost = node[1];
				
				int nextCost = curCost+cost;
				
				if (nextCost<costs[nextNode]) {
					costs[nextNode] = nextCost;
					hq.add(new int[] {nextCost, nextNode});
				}
			}
		}
		
		return costs;
	}
	
	
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V, E;
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        int K = Integer.parseInt(br.readLine());
        
        List<List<int[]>> tree = new ArrayList<>();
        for (int i=0;i<V+1;i++) tree.add(new ArrayList<>());
        
        for (int i=0;i<E;i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int u, v, w;
        	u = Integer.parseInt(st.nextToken());
        	v = Integer.parseInt(st.nextToken());
        	w = Integer.parseInt(st.nextToken());
        	
        	tree.get(u).add(new int[] {v, w});
        }
        
        int[] costs = dijkstra(tree, K, V);
        
        for (int i=1;i<V+1;i++) {
        	if (costs[i]==3000000) bw.write("INF\n");
        	else bw.write(costs[i] + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}