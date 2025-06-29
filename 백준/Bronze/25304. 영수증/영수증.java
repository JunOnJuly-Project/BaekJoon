import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        
        for (int i=0;i<cnt;i++){
            st = new StringTokenizer(br.readLine());
            
            int a, b;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            sum -= a * b;
        }
        
        if (sum == 0){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

    }
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}