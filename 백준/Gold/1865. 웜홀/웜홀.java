import java.io.*;
import java.util.*;


public class Main {
	public boolean isBack (Map<int[], Integer> edges, int N, int start) throws Exception {
		int[] dists = new int[N+1];
		int max = 25000000;
		Arrays.setAll(dists, i->max);
		dists[start] = 0;

		for (int i=0;i<N;i++) {
			for (int[] edge : edges.keySet()) {
				int S, E, T;
				S = edge[0];
				E = edge[1];
				T = edges.get(edge);
				
				if (dists[S]+T<dists[E]) {
					dists[E] = dists[S]+T;
					
					if (dists[start]<0 || i==N-1) return true;
				}
			}
		}
		
		return false;
	}
	
	
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int TC = Integer.parseInt(br.readLine());
        for (int t=0;t<TC;t++) {
        	st = new StringTokenizer(br.readLine());
        	int N, M, W;
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	W = Integer.parseInt(st.nextToken());
        	
        	Map<int[], Integer> edges = new HashMap<>();
        	
        	for (int i=0;i<M;i++) {
        		st = new StringTokenizer(br.readLine());
        		int S, E, T;
        		S = Integer.parseInt(st.nextToken());
        		E = Integer.parseInt(st.nextToken());
        		T = Integer.parseInt(st.nextToken());
        		
        		int[] posKey = new int[] {S, E};
        		int[] negKey = new int[] {E, S};
        		
        	    if (edges.containsKey(posKey)) edges.put(posKey, Math.min(edges.get(posKey), T));
        	    else edges.put(posKey, T);
        	    
        	    if (edges.containsKey(negKey)) edges.put(negKey, Math.min(edges.get(negKey), T));
        	    else edges.put(negKey, T);
        	}
        	
        	for (int i=0;i<W;i++) {
        		st = new StringTokenizer(br.readLine());
        		int S, E, T;
        		S = Integer.parseInt(st.nextToken());
        		E = Integer.parseInt(st.nextToken());
        		T = Integer.parseInt(st.nextToken());
        		
        		int[] posKey = new int[] {S, E};
        		
        		if (edges.containsKey(posKey)) edges.put(posKey, Math.min(edges.get(posKey), -T));
        		else edges.put(posKey, -T);
        	}
        	
			if (isBack(edges, N, 1)) bw.write("YES\n");
			else bw.write("NO\n");
		}
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}