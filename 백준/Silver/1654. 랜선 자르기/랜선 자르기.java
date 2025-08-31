import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K, N;
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        int rLim = 0;
        List<Integer> lens = new ArrayList<>();
        for (int i = 0; i < K; i++) {
        	int len = Integer.parseInt(br.readLine());
        	
        	rLim = Math.max(rLim, len);
        	lens.add(len);
        }
        
        int lLim = 1;
        int maxLen = 0;
        while (lLim <= rLim) {
        	int cutLen = (int) (((long) lLim + rLim) / 2);
        	if (cutLen <= 0) {
        		break;
        	}
        	
        	int count = 0;
        	for (int len : lens) {
        		count += len / cutLen;
        	}
        	
        	if (count >= N) {
        		lLim = cutLen + 1;
        		maxLen = Math.max(maxLen, cutLen);
        	}
        	
        	else {
        		rLim = cutLen - 1;
        	}
        }
        
        bw.write(maxLen + "");
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}