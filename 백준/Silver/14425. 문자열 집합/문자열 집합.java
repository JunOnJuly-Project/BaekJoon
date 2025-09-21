import java.io.*;
import java.util.*;

public class Main {	
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
        	stringSet.add(br.readLine());
        }
        
        int cnt = 0;
        for (int i = 0; i < M; i++) {
        	if (stringSet.contains(br.readLine())) {
        		cnt += 1;
        	}
        }
        
        bw.write(cnt + "");
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}