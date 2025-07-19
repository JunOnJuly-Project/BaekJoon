import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int[] fluids = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) fluids[i] = Integer.parseInt(st.nextToken());
        
        int l = 0;
        int r = N-1;
        int min = Integer.MAX_VALUE;
        int[] mins = new int[2];
        while (l<r) {
        	int sum = fluids[l]+fluids[r];
        	
        	if (Math.abs(sum)<min) {
        		min = Math.abs(sum);
        		mins[0] = fluids[l];
        		mins[1] = fluids[r];
        		
        	}

        	if (sum<=0) l += 1;
        	else r -= 1;
        }
        
        bw.write(mins[0] + " " + mins[1]);
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}