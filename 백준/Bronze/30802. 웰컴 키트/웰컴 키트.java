import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int[] nums = new int[6];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<6;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int T, P;
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        
        int pm = N / P;
        int ps = N % P;
        int t = 0;
        for (int num : nums){
            int an = num % T != 0 ? num/T + 1 : num/T;
            t += an;
        }
        bw.write(t + "\n");
        bw.write(pm + " " + ps);
        br.close();
        
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}