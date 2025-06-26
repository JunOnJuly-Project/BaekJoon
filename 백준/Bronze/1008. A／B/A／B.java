import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double a, b;
		a = Double.parseDouble(st.nextToken());
		b = Double.parseDouble(st.nextToken());
		
		System.out.printf("%.9f", a/b);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}