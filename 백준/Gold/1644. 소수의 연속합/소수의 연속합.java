import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
    
        int N = Integer.parseInt(br.readLine());
    
        // 소수 리스트 겸 부분합 리스트
        List<Integer> primes = new ArrayList<>();
        // 부분합 리스트라 0 추가
        primes.add(0);
    
        // 소수 판별 어레이
        boolean[] isPrime = new boolean[N+1];
        // 순회
        for (int i = 2;i < N + 1; i++) {
	        // 소수면
    	    if (isPrime[i] != true) {
	        	// 기록과 동시에 부분합 리스트로 만들기
    	    	primes.add(i + primes.get(primes.size() - 1));
    		    // 비소수 체크
                // i*i 는 오버플로우가 발생할 수 있으니 2*i 부터 카운팅
    		    for (int j = 2 * i; j < N + 1; j += i) {
    			    isPrime[j] = true;
    		    }
    	    }
        }
    
        // 투포인터
        int l = 0;
        int r = 1;
        int cnt = 0;
        // 탐색 시작
        while (r < primes.size()) {
	        // 현재 구간의 연속합
    	    int sum = primes.get(r)-primes.get(l);
    	    // 구간 연속합이 목표값이면
    	    if (sum == N) {
	    	    // 카운팅
    		    cnt += 1;
    		    // 포인터 이동
    		    r += 1;
    	    }
      
            // 목표값보다 작으면
    	    else if (sum<N) {
	    	    // 포인터 이동
	    	    r += 1;
    	    }
    	    else {
	    	    // 포인터 이동
	    	    l += 1;
	        }
        }
    
        // 출력
        bw.write(cnt+"");
        br.close();
        bw.flush();
        bw.close();
      }
  
      public static void main(String[] args) throws Exception {
          new Main().solution();
      }
}