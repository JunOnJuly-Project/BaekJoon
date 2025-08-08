import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        // 버퍼, 토큰화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        // 입력
        int N = Integer.parseInt(br.readLine());
        // 1000 이하의 수
        int lim = 1000;
        
        // 입력
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        // 소수인지 체크할 어레이, 소수면 0 / 아니면 1
        int[] check = new int[lim+1];
        // 0, 1 은 소수가 아님
        check[0] = 1;
        check[1] = 1;
        // 순회하며 체크
        for (int i=2;i<=lim;i++){
            // 현재 수가 소수면
            if (check[i] == 0) {
                 // 배수는 모두 소수가 아니므로 체크
                for (int j=i*i;j<=lim;j+=i){
                    check[j] = 1;
                }
            }
        }
        
        // 카운트
        int cnt = 0;
        // 수 목록 순회하며 소수 체크
        for (int num : nums) {
            if (check[num] == 0){
                cnt += 1;
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