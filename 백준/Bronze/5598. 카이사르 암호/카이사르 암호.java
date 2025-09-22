import java.io.*;
import java.util.*;

public class Main {	
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String word = br.readLine();
        for (int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	
        	bw.write(c - 3 < 'A' ? c + 23 : c - 3);
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}