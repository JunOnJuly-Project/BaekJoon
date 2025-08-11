import java.io.*;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        // 버퍼
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 입력
        int T = Integer.parseInt(br.readLine());
        // DP 배열
        int[] memo = new int[11];
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;
        
        // 1, 2, 3 의 합으로 나타낼 때
        // 경우의 수는 다음과 같다
        // ex) 4의 경우
        // 3 의 모든 경우의 맨 뒤에 1 을 붙이는 경우
        // 2 의 모든 경우의 맨 뒤에 2 를 붙이는 경우
        // 1 의 모든 경우의 맨 뒤에 3 을 붙이는 경우
        // ---------------------------------------
        // [맨 뒤에 1 을 붙이는 경우] ← memo[3]의 경우들 + 1
        // 1+1+1+1
        // 1+2+1
        // 2+1+1
        // 3+1

        // [맨 뒤에 2 를 붙이는 경우] ← memo[2]의 경우들 + 2
        // 1+1+2
        // 2+2

        //[맨 뒤에 3 을 붙이는 경우] ← memo[1]의 경우들 + 3
        //1+3
        // ---------------------------------------
        for (int i=4;i<11;i++) {
	        memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }
        // 출력
        for (int i=0;i<T;i++) {
        	int n = Integer.parseInt(br.readLine());
        	bw.write(memo[n] + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}