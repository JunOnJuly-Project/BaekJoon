import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 버퍼, 토큰화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        // 최댓값인 10000 이하의 모든 소수 구하기 -> 에라토스테네스의 체
        final int LIMIT = 10000;
        // 소수 판별 어레이
        boolean[] isPrime = new boolean[LIMIT + 1];
        isPrime[0] = true;
        isPrime[1] = true;
        // 소수 리스트
        List<Integer> primes = new ArrayList<Integer>();
        // 순회
        // 모든 소수를 리스트에 담기 위해 전체 순회
        for (int i = 2; i < LIMIT + 1; i++) {
        	// 현재 수가 소수면
        	if (isPrime[i] == false) {
        		// 소수 리스트에 추가
        		primes.add(i);
        		// 배수는 모두 소수가 아님
        		for (int j = i * i; j < LIMIT + 1; j += i) {
        			isPrime[j] = true;
        		}
        	}
        }
        
        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
        	// 입력
        	int n = Integer.parseInt(br.readLine());
        	
        	// 투포인터
        	// 차이가 가장 작은 쌍을 찾기위해 양 끝에서 시작
        	int l, r;
        	l = 0;
        	r = primes.size() - 1;
        	// 골드바흐 파티션 쌍
        	int[] pair = new int[2];
        	// 두 포인터가 겹칠 때 까지 순회
        	// 두 값이 같은 경우도 있으니 같은 경우도 포함
        	while (l <= r) {
        		// 값
        		int lNum = primes.get(l);
        		int rNum = primes.get(r);
        		// 합
        		int sum = lNum + rNum;
        		// 합이 n 미만이면
        		if (sum < n) {
        			// l 포인터를 우측으로 이동
        			l += 1;
        		}
        		
        		// 합이 n 초과면
        		else if ( sum > n) {
        			// r 포인터를 좌측으로 이동
        			r -= 1;
        		}
        		
        		// 합이 n 이면
        		else {
        			// 파티션 쌍 등록
        			pair[0] = l;
        			pair[1] = r;
        			// l 포인터를 우측으로 이동
        			l += 1;
        		}
        	}
        	
        	// 출력
        	bw.write(
                primes.get(pair[0]) + 
                " " + 
                primes.get(pair[1]) + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}