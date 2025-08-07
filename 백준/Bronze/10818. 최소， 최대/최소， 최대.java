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
        st = new StringTokenizer(br.readLine());
        
        // 최솟값, 최댓값 비교을 위한 초기화
        int max = -1000001;
        int min = 1000001;
        for (int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            // 비교 및 갱신
            max = num > max ? num : max;
            min = num < min ? num : min;
        }
        
        // 출력
        bw.write(String.format("%d %d", min, max));
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}