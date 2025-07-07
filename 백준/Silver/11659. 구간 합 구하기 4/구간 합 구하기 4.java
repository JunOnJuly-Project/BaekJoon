import java.io.*;
import java.util.*;


public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
        	int num = Integer.parseInt(st.nextToken());
    		arr[i+1] = arr[i] + num;
        }
        
        for (int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int s, e;
        	s = Integer.parseInt(st.nextToken());
        	e = Integer.parseInt(st.nextToken());
        	
        	bw.write(arr[e] - arr[s-1] +  "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}