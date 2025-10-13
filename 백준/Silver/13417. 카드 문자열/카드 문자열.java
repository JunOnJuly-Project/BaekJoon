import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T  = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				String s = st.nextToken();
				
				if (sb.length() == 0 || sb.toString().compareTo(s) < 0) {
					sb.append(s);
				}
				
				else {
					sb.insert(0, s);
				}
			}
			
			bw.write(sb.toString() + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}