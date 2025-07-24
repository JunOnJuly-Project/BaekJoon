import java.io.*;
import java.util.*;


public class Main {
	public int find(int[] group, int n) throws Exception{
		if (group[n]!=n) group[n] = find(group, group[n]);
		return group[n];
	}
	
	
	public boolean union(int[] group, int n1, int n2) throws Exception{
		int g1 = find(group, n1);
		int g2 = find(group, n2);
		
		if (g1==g2) return false;
		
		if (g1<g2) group[g2] = g1;
		else group[g1] = g2;
		
		return true;
	}
	
	
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[][] edges = new int[M][3];
        for (int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int A, B, C;
        	A = Integer.parseInt(st.nextToken());
        	B = Integer.parseInt(st.nextToken());
        	C = Integer.parseInt(st.nextToken());
        	
        	edges[i] = new int[] {A, B, C};
        }
        
        Arrays.sort(edges, (a, b)->a[2]-b[2]);
        
        int[] group = new int[N+1];
        Arrays.setAll(group, i->i);
        
        int cost = 0;
        List<Integer> costs = new ArrayList<>();
        for (int i=0;i<M;i++) {
        	int[] edge = edges[i];
        	int A, B, C;
        	
        	A = edge[0];
        	B = edge[1];
        	C = edge[2];
        	
        	if (union(group, A, B)) {
        		costs.add(C);
        	}
        }
        
        for (int i=0;i<costs.size()-1;i++) {
        	cost += costs.get(i);
        }
        
        bw.write(cost+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}