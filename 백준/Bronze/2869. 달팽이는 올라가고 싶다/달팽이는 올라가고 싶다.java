import java.util.*;
import java.io.*;

public class Main {
	public void solution() throws Exception {
		// 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A, B, V;
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        int limit = V - A;
        int speed = A - B;
        
        bw.write(limit % speed == 0 ? limit / speed + 1 + "" : limit / speed + 2 + "");
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}