import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ty = Integer.parseInt(br.readLine());
		
		System.out.println(ty-543);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}