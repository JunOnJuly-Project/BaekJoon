import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        // 버퍼, 토크화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            
            // 문자열을 순회하며 문자 반복 출력
            for (int j=0;j<S.length();j++){
                bw.write(Character.toString(S.charAt(j)).repeat(N) + "");
            }
            
            bw.write("\n");
        }
        
        // 버퍼 관리
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}