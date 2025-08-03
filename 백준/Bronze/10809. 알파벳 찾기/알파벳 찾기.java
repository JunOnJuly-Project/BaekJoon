import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String word = br.readLine();
        int[] cs = new int[26];
        Arrays.fill(cs, -1);
        
        for (int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            
            for (int j=0;j<26;j++){
                if (cs[j] == -1 && c == 'a' + j) {
                    cs[j] = i;
                    break;
                }
            }
        }
        
        for (int i : cs) {
            bw.write(i + " ");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}