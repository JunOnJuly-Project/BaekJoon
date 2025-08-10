import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] nums = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
        	String stringN = String.valueOf(i);
        	
        	int decompSum = i;
        	for (int j = 0; j < stringN.length(); j++) {
        		decompSum += Character.getNumericValue(stringN.charAt(j));
        	}
        	
        	if (decompSum <= N && nums[decompSum] == 0) {
        		nums[decompSum] = i;
        	}
        }
        
        bw.write(nums[N] + "");
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}