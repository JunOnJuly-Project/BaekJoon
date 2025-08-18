import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 버퍼, 토큰화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 입력
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
        	nums[i] = Integer.parseInt(br.readLine());
        }
        
        // 오름차순 정렬
        Arrays.sort(nums);
        
        // 투포인터
        int l, r;
        l = 0;
        r = 0;
        
        // M 이상인 최소차이
        int min = Integer.MAX_VALUE;
        
        // r 이 마지막을 초과할 때 까지
        while (r < N) {
        	// 두 값
        	int nL, nR;
        	nL = nums[l];
        	nR = nums[r];
        	// 두 값의 차이
        	int sub = nR - nL;
        	// 두 값의 차이가 M 미만이면
        	if (sub < M) {
        		// 차이가 커져야 하므로 r 옮기기
        		r += 1;
        	}
        	
        	// 두 수의 차이가 M 초과면
        	else if (sub > M) {
        		// 최솟값 갱신
        		min = Math.min(min,  sub);
        		// 차이가 작아져야 하므로 l 옮기기
        		l += 1;
        	}
        	
        	// 두 수의 차이가 M 이면 가작 작은 차이니까 갱신 후 종료
        	else {
        		min = M;
        		break;
        	}
        }
        
        bw.write(min + "");
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}