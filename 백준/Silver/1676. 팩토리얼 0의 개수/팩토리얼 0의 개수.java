import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 버퍼, 토큰화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int result = 0;
        for (int i = 0; i < N + 1; i++) {
        	int j = i;
        	while (j % 5 == 0 && (j /= 5) != 0) {
        		result += 1;
        	}
        }
        
        bw.write(result + "");
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}