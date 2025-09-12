import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int L = Integer.parseInt(br.readLine());
	    String str = br.readLine();
	    
	    int r, M;
	    r = 31;
	    M = 1234567891;
	    
	    Long[] pows = new Long[L];
	    pows[0] = 1L;
	    for (int i = 1; i < L; i ++) {
	    	pows[i] = pows[i-1] * r % M;
	    }
	    
	    long hash = 0;
	    for (int i = 0; i < str.length(); i++) {
	    	char c = (char) (str.charAt(i) - 'a' + 1);
	    	hash += c * pows[i] % M;
	    	hash %= M;
	    }
	    
	    // 출력
	    bw.write(hash + "");
	    br.close();
	    bw.flush();
	    bw.close();
	  }
	  
	  public static void main(String[] args) throws Exception {
	      new Main().solution();
	  }
}