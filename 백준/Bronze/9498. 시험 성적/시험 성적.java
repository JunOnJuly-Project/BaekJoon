import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n;
        n = Integer.parseInt(st.nextToken());
        
        String result;
        result = 	n >= 90 ? "A" :
        			n >= 80 ? "B" :
        			n >= 70 ? "C" :
        			n >= 60 ? "D" :
        			"F";
        
        System.out.println(result);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}