import java.io.*;
import java.util.*;

public class Main {
	boolean isStackable(int M, String before, String cur) {
		for (int i = 0; i < M; i++) {
			if ((before.substring(0, i + 1).equals(cur.substring(M - 1 - i, M))) ||
				(cur.substring(0, i + 1).equals(before.substring(M - 1 - i, M)))) {
				return true;
			}
		}
		
		return false;
	}

	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
        	words[i] = br.readLine();
        }
        
        for (int i = 1; i < N; i++) {
        	String before = words[i - 1];
        	String cur = words[i];
        	
        	if (i > 0) {
        		if (isStackable(M, before, cur) != true) {
        			bw.write(0 + "");
        			break;
        		}
        		
        		else if (i == N - 1) {
        			bw.write(1 + "");
        		}
        	}
        }
        
        if (N == 1) {
        	bw.write(1 + "");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}