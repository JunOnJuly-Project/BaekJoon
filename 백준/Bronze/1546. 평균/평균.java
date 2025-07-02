import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
       
        int N = Integer.parseInt(br.readLine());
        float m = 0f;
        st = new StringTokenizer(br.readLine());
        float M = 0f;
        for (int i=0;i<N;i++){
            float sc = Float.parseFloat(st.nextToken());
            M = sc>M ? sc : M;
            m += sc/N;
        }
        bw.write(String.format("%.2f", m/M*100));
        br.close();
        
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}