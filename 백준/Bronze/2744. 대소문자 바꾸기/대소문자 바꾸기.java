import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    String s = br.readLine();
	    String r = "";
	    
	    for (int i = 0; i < s.length(); i++) {
	    	char c = s.charAt(i);
	    	if (Character.isUpperCase(c)) {
	    		r += Character.toLowerCase(c);
	    	}
	    	
	    	else {
	    		r += Character.toUpperCase(c);
	    	}
	    }
	    
	    // 출력
	    bw.write(r);
	    br.close();
	    bw.flush();
	    bw.close();
	  }
	  
	  public static void main(String[] args) throws Exception {
	      new Main().solution();
	  }
}