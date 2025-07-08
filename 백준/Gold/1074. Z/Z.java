import java.io.*;
import java.util.*;


public class Main {
	public int selectArea(int N, int r, int c) throws Exception {
		if (N==0) return 1;
		
		int halfLen = (int)Math.pow(2, N-1);
		int cnt = 0;
		int state;
		
		if (r>=halfLen && c>=halfLen) {
			state = 3;
			cnt += selectArea(N-1,  r-halfLen, c-halfLen);
		}
		else if (r>=halfLen && c<halfLen) {
			state = 2;
			cnt += selectArea(N-1,  r-halfLen, c);
		}
		else if (r<halfLen && c>=halfLen) {
			state = 1;
			cnt += selectArea(N-1,  r, c-halfLen);
		}
		else {
			state = 0;
			cnt += cnt += selectArea(N-1,  r, c);
		}
		
		return state * (int)Math.pow(halfLen, 2) + cnt;
	}
	
	
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N, r, c;
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        int cnt = selectArea(N, r, c)-1;
        
        bw.write(cnt+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}