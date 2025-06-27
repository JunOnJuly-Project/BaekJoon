import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a, b;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		int time = a*60 + 1440 + b - 45;
		
		System.out.printf("%d %d", (time/60)%24, time%60);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}