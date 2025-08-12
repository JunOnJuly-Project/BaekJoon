import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 버퍼, 토큰화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int mul = 1;
        for (int i = 0; i < 3; i++) {
        	mul *= Integer.parseInt(br.readLine());
        }
        
        String mulString = String.valueOf(mul);
        
        int[] cnts = new int[10];
        for (int i = 0; i < mulString.length(); i++) {
        	cnts[mulString.charAt(i) - '0'] += 1;
        }
        
        for (int n : cnts) {
        	bw.write(n + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}