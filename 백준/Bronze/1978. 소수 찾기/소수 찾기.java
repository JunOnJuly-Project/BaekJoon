import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int lim = 1000;
        
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        
        int[] check = new int[lim+1];
        Arrays.setAll(check, i -> i);
        int cnt = 0;
        for (int i=2;i<=lim;i++){
            if (check[i] != 0) {
                if (Arrays.binarySearch(nums, i) >= 0){
                    cnt += 1;
                }
                for (int j=i*2;j<=lim;j+=i){
                    check[j] = 0;
                }
            }
        }
        bw.write(cnt+"");
        br.close();
        
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}