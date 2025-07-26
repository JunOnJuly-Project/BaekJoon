import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        String a = br.readLine();
        String b = br.readLine();
        
        int aLen = a.length();
        int bLen = b.length();
        
        int[][] memo = new int[aLen+1][bLen+1];
        for (int i=1;i<aLen+1;i++) {
        	for (int j=1;j<bLen+1;j++) {
        		if (a.charAt(i-1)==b.charAt(j-1)) memo[i][j] = memo[i-1][j-1]+1;
        		else {
        			if (memo[i-1][j]>=memo[i][j-1]) memo[i][j] = memo[i-1][j];
        			else memo[i][j] = memo[i][j-1];
        		}
        	}
        }
        
        bw.write(memo[aLen][bLen] + "\n");
        
        Deque<Character> dq = new LinkedList<>();
        int i = aLen;
        int j = bLen;
        while (i>0 && j>0) {
        	if (a.charAt(i-1)==b.charAt(j-1)) {
        		dq.addFirst(a.charAt(i-1));
        		i -= 1;
        		j -= 1;
        	}
        	
        	else if (memo[i-1][j]>memo[i][j-1]) {
        		i -= 1;
        	}
        	
        	else j -= 1;
        }
        
        for (char c : dq) bw.write(c);
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}