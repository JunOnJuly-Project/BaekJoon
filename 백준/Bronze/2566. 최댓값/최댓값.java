import java.util.*;
import java.io.*;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int max = -1;
		int[] idxs = new int[] {-1, -1};
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if (num > max) {
					max = num;
					idxs[0] = i + 1;
					idxs[1] = j + 1;
				}
			}
		}
		
		bw.write(max + "\n");
		bw.write(idxs[0] + " " + idxs[1]);
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}