import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        String nums = br.readLine();
        
        int sum = 0;
        for (int i=0;i<N;i++){
            sum += Character.getNumericValue(nums.charAt(i));
        }
        
        bw.write(sum+"");
        br.close();
        
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}