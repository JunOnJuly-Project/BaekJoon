import java.util.*;
import java.io.*;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int H, W, N;
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			int div = (N - 1) / H + 1;
			int mod = (N - 1) % H + 1;
			
			bw.write(String.format("%d%02d\n", mod, div));
		}
        bw.flush();
        bw.close();
        br.close();
	}
	
	public static void main( String[] args ) throws Exception {
		new Main().solution();
	}
}