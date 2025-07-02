import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i=0;i<N;i++) nums[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(nums);
        
        for (int n : nums) bw.write(n + "\n");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}