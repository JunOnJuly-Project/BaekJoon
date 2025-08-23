import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n];
        
        for (int i = 0; i < n; i++) {
        	scores[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(scores);
        
        int cut = (int) Math.round((double) n / 100 * 15);
        
        int sum = 0;
        for (int i = cut; i < n - cut; i++) {
        	sum += scores[i];
        }
        
        bw.write(Math.round((double) sum/(n - 2 * cut)) + "");
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}