import java.io.*;
import java.util.*;

public class Main {	
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long N, M;
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        
        bw.write(Math.abs(N - M) + "");
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}