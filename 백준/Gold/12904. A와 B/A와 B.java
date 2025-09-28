import java.io.*;
import java.util.*;

public class Main {	
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        
        String S = br.readLine();
        String T = br.readLine();
        
        int SLen = S.length();
        int TLen;
        
        while((TLen = T.length()) > SLen) {
        	if (T.charAt(TLen - 1) == 'A') {
        		T = T.substring(0, TLen - 1);
        		continue;
        	}
        	
        	else {
        		sb = new StringBuilder(T.substring(0, TLen - 1));
        		T = sb.reverse().toString();
        	}
        }
        
        bw.write(S.equals(T) ? 1 + "" : 0 + "");
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}