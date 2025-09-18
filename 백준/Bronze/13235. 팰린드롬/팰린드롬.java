import java.io.*;
import java.util.*;

public class Main {
	boolean isPalindrome(String word) {
		int wordLen = word.length();
		
		for (int i = 0; i < wordLen/2; i++) {
        	if (word.charAt(i) != word.charAt(wordLen - 1 - i)) {
        		return false;
        	}
        }
		
		return true;
	}
	
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String word = br.readLine();
        String result = isPalindrome(word) ? "true" : "false";
        
        bw.write(result);
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}