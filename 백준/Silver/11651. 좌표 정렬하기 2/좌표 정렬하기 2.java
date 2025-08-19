import java.util.*;
import java.io.*;

public class Main {
	public void solution() throws Exception {
		// 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] idxs = new int[N][2];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	idxs[i][0] = Integer.parseInt(st.nextToken());
        	idxs[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(idxs, (a, b) -> {
        	return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
        });
        
        for (int i = 0; i < N; i++) {
        	bw.write(idxs[i][0] + " " + idxs[i][1] + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}