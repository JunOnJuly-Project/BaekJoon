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
        // 전체 점수
        float sum = 0f;
        // 최대 점수
        float max = 0f;
        
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            // 점수
            float score = Float.parseFloat(st.nextToken());
            // 최대점수 갱신
            max = score > max ? score : max;
            // 합계 갱신
            sum += score;
        }
        
        // 전체점수 / 과목 수 = 평균
        // 평균 / 최대 점수의 비율 = 새로운 평균
        // 나누기는 선형 계산이므로
        // 평균값을 한번에 최댓값으로 나누어줘도
        // 각 값을 나눠서 평균을 낸 값과 일치한다.
        // 상대오차가 10^(-2) 까지 허용이므로
        // 그냥 소수점 둘째 자리까지 출력해도 허용된다.
        // 출력
        bw.write(String.format("%.2f", sum / N * (100 / max)));
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}