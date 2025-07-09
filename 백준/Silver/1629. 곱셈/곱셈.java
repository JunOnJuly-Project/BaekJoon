import java.io.*;
import java.util.*;


public class Main {
	public long quickPow(int A, int B, int C) throws Exception {
		if (B==1) return A % C;
		
		long halfPow = quickPow(A, B/2, C) % C;
		long binResult = halfPow*halfPow % C;
		if (B%2==0) return binResult;
		else return A*binResult % C;
	}
	
	
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A, B, C;
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        Long result = quickPow(A, B, C);
        
        bw.write(result+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}