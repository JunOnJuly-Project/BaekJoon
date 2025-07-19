import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        long[][] idxs = new long[N][2];
        for (int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	idxs[i][0] = Long.parseLong(st.nextToken());
        	idxs[i][1] = Long.parseLong(st.nextToken());
        }
        
        Long result = 0L;
        for (int i=1;i<N-1;i++) {
        	long[] xs = new long[] {idxs[0][0], idxs[i][0], idxs[i+1][0], idxs[0][0]};
        	long[] ys = new long[] {idxs[0][1], idxs[i][1], idxs[i+1][1], idxs[0][1]};
        	
        	long ccw = 0;
        	for (int j=0;j<3;j++) ccw += xs[j]*ys[j+1];
        	for (int j=0;j<3;j++) ccw -= ys[j]*xs[j+1];
        	result += ccw;
        }
        
        result = Math.abs(result);
        bw.write(result%2==0 ? result/2+".0" : result/2 + ".5");

        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}