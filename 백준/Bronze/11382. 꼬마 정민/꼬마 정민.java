import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long result = 0L;
		for (int i=0;i<=2;i++) {
			result += Long.parseLong(st.nextToken());
		}
		
		System.out.println(result);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}