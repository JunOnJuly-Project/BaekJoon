import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N, S;
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {	
        	nums[i+1] = Integer.parseInt(st.nextToken()) + nums[i];
        }
        
        int minLen = 100001;
        int l = 1;
        int r = 1;
        while(true) {
        	if (nums[r]-nums[l-1]<S) r += 1;
        	else {
        		minLen = r-l+1<minLen ? r-l+1 : minLen;
        		l += 1;
        	}
        	
        	if ((r>=N) && nums[r]-nums[l-1]<S) break;
        }
       
        bw.write(minLen==100001 ? 0+"" : minLen+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}