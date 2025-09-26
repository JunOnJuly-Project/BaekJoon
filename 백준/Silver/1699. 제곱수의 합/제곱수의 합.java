import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		int[] minCnts = new int[N + 1];
		Arrays.fill(minCnts, Integer.MAX_VALUE);
		List<Integer> sqrs = new ArrayList<>();
		
		int num = 1;
		int sqrNum = num * num;
		
		while (sqrNum <= N) {
			minCnts[sqrNum] = 1;
			sqrs.add(sqrNum);
			
			num += 1;
			sqrNum = num * num;
		}
		
		for (int i = 2; i < N + 1; i ++) {
			if (sqrs.contains(i)) {
				continue;
			}
			
			for (int sqr : sqrs) {
				if (sqr >= i) {
					break;
				}
				
				minCnts[i] = Math.min(minCnts[i], minCnts[i - sqr] + 1);
			}
		}
		
		bw.write(minCnts[N] + "");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}