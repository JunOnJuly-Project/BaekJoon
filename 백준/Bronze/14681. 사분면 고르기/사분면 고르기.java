import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		int result;
		if (a>0) {
			if (b>0) {
				result = 1;
			}
			else {
				result = 4;
			}
		}
		else {
			if (b>0) {
				result = 2;
			}
			else {
				result = 3;
			}
		}
		
		System.out.println(result);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}