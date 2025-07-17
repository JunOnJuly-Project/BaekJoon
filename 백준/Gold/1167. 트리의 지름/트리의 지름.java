import java.io.*;
import java.util.*;


public class Main {
	public int[] dijkstra(List<List<int[]>> tree, int start, int n) throws Exception {
		int[] dists = new int[n+1];
		Arrays.setAll(dists, i->Integer.MAX_VALUE);
		dists[start] = 0;
		
		PriorityQueue<int[]> hq = new PriorityQueue<>((a, b)->a[1]-b[1]);
		hq.add(new int[] {start, 0});
		while (!hq.isEmpty()) {
			int[] curArr = hq.poll();
			int curNode = curArr[0];
			int curDist = curArr[1];
			
			if (curDist>dists[curNode]) continue;
			
			for (int[] nextArr : tree.get(curNode)) {
				int nextNode = nextArr[0];
				int nextDist = curDist+nextArr[1];
				
				if (nextDist<dists[nextNode]) {
					dists[nextNode] = nextDist;
					hq.add(new int[] {nextNode, nextDist});
				}
			}
		}
		
		int max = 0;
		int maxIdx = 0;
		for (int i=1;i<n+1;i++) {
			if (dists[i]>max) {
				max = dists[i];
				maxIdx = i;
			}
			
		}
		
		return new int[] {max, maxIdx};
	}
	
	
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        List<List<int[]>> tree = new ArrayList<>();
        for (int i=0;i<n+1;i++) {
        	tree.add(new ArrayList<>());
        }
        
        for (int i=0;i<n-1;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a;
        	a = Integer.parseInt(st.nextToken());
        	
        	int b, c;
        	while ((b = Integer.parseInt(st.nextToken()))!=-1) {
        		c = Integer.parseInt(st.nextToken());
        		
        		tree.get(a).add(new int[] {b, c});
        		tree.get(b).add(new int[] {a, c});
        	}
        	
        }
        
        if (n==1) bw.write(0+"");
        else {
        	int[] candid = dijkstra(tree, 1, n);
        	int[] rad = dijkstra(tree, candid[1], n);
        	bw.write(rad[0]+"");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}