import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N, K;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        int[][] items = new int[N][2];
        for (int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	items[i][0] = Integer.parseInt(st.nextToken());
        	items[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int[] knapSack = new int[K+1];
        for (int i=0;i<N;i++) {
        	int W, V;
        	W = items[i][0];
        	V = items[i][1];
        	
        	for (int j=K;j>=0;j--) {
        		if (j>=W) {
        			for (int k=0;k<N;k++) {
        				int candid = knapSack[j-W]+V;
        				knapSack[j] = candid>knapSack[j] ? candid : knapSack[j];
        			}
        		}        		
        	}
        }
        
        bw.write(knapSack[K]+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
   
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}