import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        long[] fluids = new long[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) fluids[i] = Long.parseLong(st.nextToken());
        
        Arrays.sort(fluids);
        
        long min = Long.MAX_VALUE;
        int[] minArr = new int[3];
        for (int i=0;i<N-2;i++) {
        	for (int j=N-1;j>i+1;j--) {
        		long sum = fluids[i] + fluids[j];
        		
        		int zeroIdx = Arrays.binarySearch(fluids, i+1, j, -sum);
        		
        		if (zeroIdx>i) {
        			bw.write(String.format("%d %d %d", fluids[i], fluids[zeroIdx], fluids[j]));
        			min = 0;
        			break;
        		}
        		
        		else {
        			if (zeroIdx!=-j-1) {
        				if (Math.abs(fluids[i] + fluids[-zeroIdx-1] + fluids[j])<min) {
        					min = Math.abs(fluids[i] + fluids[-zeroIdx-1] + fluids[j]);
        					minArr = new int[] {i, -zeroIdx-1, j};
        				}
        			}
        				
        			if (zeroIdx!=-i-1-1) {
        				if (Math.abs(fluids[i] + fluids[-zeroIdx-1-1] + fluids[j])<min) {
        					min = Math.abs(fluids[i] + fluids[-zeroIdx-1-1] + fluids[j]);
        					minArr = new int[] {i, -zeroIdx-1-1, j};
        				}
        			}
        		}
        	}
        	
        	if (min==0) break;
        }
        
        if (min!=0) bw.write(String.format("%d %d %d", fluids[minArr[0]], fluids[minArr[1]], fluids[minArr[2]]));
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}