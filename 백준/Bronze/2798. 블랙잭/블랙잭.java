import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        
        int max = 0;
        for (int i=0;i<N-2;i++){
            for (int j=i+1;j<N-1;j++){
                for (int k=j+1;k<N;k++){
                    int sumPart = nums[i] + nums[j] + nums[k];
                    
                    if (sumPart > M) break;
                    else max = sumPart > max ? sumPart : max;
                }
                
                if (nums[i] + nums[j] > M) break;
            }
            
            if (nums[i] > M) break;
        }
        
        bw.write(max+"");
        br.close();
        
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}