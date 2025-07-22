import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int C, N;
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        int[][] costs = new int[N][2];
        for (int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a, b;
        	a = Integer.parseInt(st.nextToken());
        	b = Integer.parseInt(st.nextToken());
        	
        	costs[i] = new int[] {a, b};
        }
        
        int[] knapsack = new int[100001];
        for (int i=1;i<knapsack.length;i++) {
        	for (int j=0;j<N;j++) {
        		int[] cost = costs[j];
        		int c = cost[0];
        		int p = cost[1];
        		
        		if (c<=i) {
        			knapsack[i] = Math.max(knapsack[i], knapsack[i-c]+p);
        		}
        	}
        	
        	if (knapsack[i]>=C) {
        		bw.write(i+"");
        		break;
        	}
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}