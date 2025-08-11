import java.util.*;
import java.io.*;

public class Main {
	public void solution() throws Exception {
		// 버퍼, 토큰
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력
		int M, N;
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		// N 이하의 모든 소수 탐색
		// 소수 여부 배열
		boolean[] isPrime = new boolean[N + 1];
		isPrime[0] = true;
		isPrime[1] = true;
		// 순회 한계
		int limit = (int) (Math.sqrt(N)) + 1;
		// 순회
		for (int i = 2; i < limit; i++) {
			// 소수면
			if (isPrime[i] == false) {
				// 배수는 모두 소수가 아니므로 체크
				for (int j = i*i; j < N + 1; j += i) {
					isPrime[j] = true;
				}
			}
		}
		
		// 소수 판정 배열 순회하며 출력
		for (int i = M; i < N + 1; i++) {
			if (isPrime[i] == false) {
				bw.write(i + "\n");
			}
		}
		
		// 출력
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}