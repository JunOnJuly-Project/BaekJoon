import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
        
        int result = 0;
        for (int i=1;i<=n;i++){
            result += i;
        }
        
        System.out.println(result);
    }
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}