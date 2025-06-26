import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A, B, C;
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println((A+B) % C);
		System.out.println(((A%C) + (B%C)) % C);
		System.out.println((A*B) % C);
		System.out.println(((A%C) * (B%C)) % C);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}