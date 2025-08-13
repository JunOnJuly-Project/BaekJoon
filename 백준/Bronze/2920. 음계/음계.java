import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 버퍼, 토큰화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String result = "";
        for (int i = 0; i < 8; i++) {
        	int nextInt = Integer.parseInt(st.nextToken());
        	
        	if (result.equals("")) {
        		if (nextInt == i + 1) {
        			result = "ascending";
        		}
        		
        		else if (nextInt == 8 - i) {
        			result = "descending";
        		}
        		
        		else {
        			result = "mixed";
        			break;
        		}
        	}
        	
        	else if (result.equals("ascending")) {
        		if (nextInt == i + 1) {
        			result = "ascending";
        		}
        		
        		else {
        			result = "mixed";
        			break;
        		}
        	}
        	
        	else {
        		if (nextInt == 8 - i) {
        			result = "descending";
        		}
        		
        		else {
        			result = "mixed";
        			break;
        		}
        	}
        }
        
        bw.write(result);
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}