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
        
        int T = Integer.parseInt(br.readLine());
        int[][] memo = new int[41][2];
        memo[0][0] = 1;
        memo[0][1] = 0;
        memo[1][0] = 0;
        memo[1][1] = 1;
        
        for (int i=2;i<41;i++){
            for (int j=0;j<2;j++){
                memo[i][j] = memo[i-1][j] + memo[i-2][j];
            }
        }
 
        for (int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            
            bw.write(String.format("%d %d\n", memo[n][0], memo[n][1]));
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}