import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] nums = new int[3];
            
            for (int i=0;i<3;i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }
            
            if (nums[0]==0){
                break;
            }
            
            Arrays.sort(nums);
            if (Math.pow(nums[2], 2) == Math.pow(nums[0], 2) + Math.pow(nums[1], 2)){
                bw.write("right\n");
            }
            else{
                bw.write("wrong\n");
            }
        }
        br.close();
        
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}