import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[][] graph = new int[n+1][n+1];
        for (int i=0;i<n+1;i++) for (int j=0;j<n+1;j++) graph[i][j] = i==j ? 0 : Integer.MAX_VALUE;
        for (int i=0;i<m;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a, b, c;
        	a = Integer.parseInt(st.nextToken());
        	b = Integer.parseInt(st.nextToken());
        	c = Integer.parseInt(st.nextToken());
        	
        	graph[a][b] = c<graph[a][b] ? c : graph[a][b];
        }
        
        for (int c=1;c<n+1;c++) {
        	for (int s=1;s<n+1;s++) {
        		for (int e=1;e<n+1;e++) {
        			if (graph[s][c]!=Integer.MAX_VALUE && graph[c][e]!=Integer.MAX_VALUE) graph[s][e] = Math.min(graph[s][c] + graph[c][e], graph[s][e]);
        		}
        	}
        }
        
        for (int i=1;i<n+1;i++) {
        	for (int j=1;j<n+1;j++) {
        		if (graph[i][j]==Integer.MAX_VALUE) bw.write(0 + " ");
        		else bw.write(graph[i][j] + " ");
        	}
        	bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}