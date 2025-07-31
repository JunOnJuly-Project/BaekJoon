import java.util.*;
import java.io.*;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int C = Integer.parseInt(br.readLine());
		for (int c=0;c<C;c++) {
			st = new StringTokenizer(br.readLine());
			int d, n;
			d = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			Map<Integer, Integer> numsCnt = new HashMap() {};
			numsCnt.put(0, 1);
			
			int[] nums = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<n;i++) {
				nums[i+1] = (nums[i] + Integer.parseInt(st.nextToken()))%d;
				numsCnt.put(nums[i+1], numsCnt.getOrDefault(nums[i+1], 0)+1);
			}
			
			long result = 0;
			for (long v : numsCnt.values()) result += v*(v-1)/2;
			
			bw.write(result + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}