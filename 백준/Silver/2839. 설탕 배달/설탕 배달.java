import java.util.*;
import java.io.*;

public class Main {
	public void solution() throws Exception {
		// 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        // DP 배열
        // 배열의 최소 길이는 5 -> 초기값 입력을 위해
        int[] memo = new int[Math.max(6, N + 1)];
        Arrays.fill(memo, -1);
        memo[3] = 1;
        memo[5] = 1;
        
        // 순회
        for (int i = 6; i < N + 1; i++) {
        	/*
        	 * 3 주머니를 택하는 경우
        	 * i - 3 무게에서 최적의 수가 없으면 3 주머니를 택했을 때 최적의 수가 없다.
        	 * 최적의 수가 존재했다면 해당 최적의 수 + 1
        	 */
        	memo[i] = memo[i - 3] == -1 ? -1 : memo[i - 3] + 1;
        	/*
        	 * 5 주머니를 택하는 경우
        	 * i - 5 무게에서 최적의 수가 없으면 5 주머니를 택했을 때 최적의 수가 없다.
        	 * 최적의 수가 존재하지 않고,
        	 * * 3 주머니를 택했을 때 최적의 수가 존재했다면 
        	 * 그대로 두기
        	 * * 3 주머니를 택했을 때 최적의 수가 존재하지 않았다면
        	 * 모든 최적의 수가 없다. == 그대로 두기
        	 * 
        	 * 최적의 수가 존재하고
        	 * * 3 주머니를 택했을 때 최적의 수가 존재했다면
        	 * 두 수중 최솟값 비교
        	 * * 3 주머니를 택했을 때 최적의 수가 존재하지 않았다면
        	 * 5 주머니의 수가 최적의 수
        	 */
        	if (memo[i - 5] == -1) {
        		continue;
        	}
        	
        	else {
        		if (memo[i] != -1) {
        			memo[i] = Math.min(memo[i], memo[i - 5] + 1);
        		}
        		
        		else {
        			memo[i] = memo[i - 5] + 1;
        		}
        	}
        }
        
        // 출력
        bw.write(memo[N] + "");        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}