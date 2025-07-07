import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i=0;i<N;i++) {
        	int tree = Integer.parseInt(st.nextToken());
        	trees[i] = tree;
        	max = tree>max ? tree : max;
        }
        
        int result = 0;
        int s, e;
        s = 0;
        e = max;
        while (s<e) {
        	int m = (e+s)/2;
        	
        	long sum = 0;
        	for (int i=0;i<N;i++) {
        		sum += trees[i] > m ? trees[i] - m : 0;
        	}
        	
        	if (sum < M) e = m;
        	else {
        		s = m+1;
        		result = m;
        	}
        }
        
        bw.write(result+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}