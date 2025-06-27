import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n;
        n = Integer.parseInt(st.nextToken());
        
        int result;
        result = (n%4 == 0 && n%100 != 0) || n%400 == 0 ? 1 : 0;
        
        System.out.println(result);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}