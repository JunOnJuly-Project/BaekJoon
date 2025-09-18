import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String S = br.readLine();
        int SLen = S.length();
        
        Set<String> stringSet = new HashSet<>();
        
        for (int i = 0; i < SLen; i++) {
        	for (int j = SLen; j > i; j--) {
        		if (stringSet.add(S.substring(i, j)) != true) {
        			break;
        		}
        	}
        }
        
        bw.write(stringSet.size() + "");
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}