import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String a, b;
        a = br.readLine();
        b = br.readLine();
        
        int al = a.length();
        int bl = b.length();
        
        int[][] lcs = new int[al+1][bl+1];
        for (int i=0;i<al;i++) {
        	for (int j=0;j<bl;j++) {
        		if (a.charAt(i)==b.charAt(j)) lcs[i+1][j+1] = Arrays.stream(new int[] {lcs[i][j]+1, lcs[i][j+1], lcs[i+1][j]}).max().getAsInt(); 
        		else lcs[i+1][j+1] = Arrays.stream(new int[] {lcs[i][j+1], lcs[i+1][j]}).max().getAsInt();
        	}
        }

        bw.write(lcs[al][bl]+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}