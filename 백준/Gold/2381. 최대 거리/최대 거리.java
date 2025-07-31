import java.util.*;
import java.io.*;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] sums = new int[2][N];
		
		int[][] idxs = new int[N][2];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x, y;
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			sums[0][i] = x+y;
			sums[1][i] = x-y;
		}
		
		Arrays.sort(sums[0]);
		Arrays.sort(sums[1]);
		
		bw.write(Math.max(sums[0][N-1]-sums[0][0], sums[1][N-1]-sums[1][0]) + " ");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}