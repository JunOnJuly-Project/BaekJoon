import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        // 버퍼, 토큰화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력
        int A, B;
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        // 최소공배수는 A * B / A 와 B 의 최대공약수
        int mulAB = A*B;
        
        // 유클리드 호제법
        // A 를 B 로 나누었을 때 나머지가 mod 라면
        // A 와 B 의 최대공약수는 B 와 mod 의 최대공약수와 같다.
        // 즉 해당과정을 반복하며 mod 가 0 이 되었을 때,
        // B 는 A 의 약수라는 의미가 되고
        // 그렇다면 B 가 A 와 B 의 최대공약수이므로
        // 결국 mod 가 0 일 때 B 가 최대 공약수가 된다.
        int mod;
        while ((mod = A%B) != 0){
            A = B;
            B = mod;
        }
        
        // 출력
        bw.write(B + "\n");
        bw.write(mulAB/B + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}