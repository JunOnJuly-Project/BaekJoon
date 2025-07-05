import java.io.*;
import java.util.*;


public class Main {
    public static int upperBound(int[] arr, int target, int start, int end){
        while(start<end){
            int mid = (start+end) / 2;
            if (arr[mid] > target) end = mid;
            else start = mid + 1;
        }
        return start;
    }
    
    public static int lowerBound(int[] arr, int target, int start, int end){
        while(start<end){
            int mid = (start+end) / 2;
            if (arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return start;
    }
    
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<M;i++){
            int m = Integer.parseInt(st.nextToken());
            int lower = lowerBound(nums, m, 0, N);
            int upper = upperBound(nums, m, 0, N);

            bw.write(upper - lower + " ");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}