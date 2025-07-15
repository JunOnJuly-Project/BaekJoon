import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] lis = new int[N];
        lis[0] = 1;
        for (int i=1;i<N;i++) {
        	int maxSub = 0;
        	for (int j=0;j<i;j++) if (nums[j]<nums[i]) maxSub = lis[j]>maxSub ? lis[j] : maxSub;
        	lis[i] = maxSub + 1;
        }
        
        int max = 0;
        for (int n:lis) max = n>max? n : max;
        
        bw.write(max+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}