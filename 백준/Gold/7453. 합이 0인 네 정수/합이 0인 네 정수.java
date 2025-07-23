import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] nums = new int[4][n];
        for (int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0;j<4;j++) {
        		int num = Integer.parseInt(st.nextToken());
        		nums[j][i] = num;
        	}
        }
        
        int[][] addNums = new int[2][n*n];
        for (int i=0;i<2;i++) {
    		for (int j=0;j<n;j++) {
    			for (int k=0;k<n;k++) {
    				addNums[i][j*n+k] = nums[i*2][j]+nums[i*2+1][k];
    			}
    		}
        }
        
        for (int i=0;i<2;i++) Arrays.sort(addNums[i]);
       
        Long result = 0L;
        int l = 0;
        int r = n*n-1;
        Long lCnt = 1L;
        Long rCnt = 1L;
        while (l<n*n && r>=0) {
        	int lNum = addNums[0][l];
        	int rNum = addNums[1][r];
        	int sum = lNum+rNum;
        	
        	if (sum==0) {
        		if (l<n*n-1 && addNums[0][l+1]==lNum) {
        			lCnt += 1;
        			l+=1;
        			continue;
        		}
        		
        		else if (r>0 && addNums[1][r-1]==rNum) {
        			rCnt += 1;
        			r-=1;
        			continue;
        		}
        		
        		else {
        			result += lCnt*rCnt;
        			lCnt = 1L;
        			rCnt = 1L;
        		}
        		
        		if (l<n*n-1) l += 1;
        		else if (r>0) r -= 1;
        		else break;
        	}
        	
        	else if (sum<0) l += 1;
        	else r -= 1;
        }
        
        bw.write(result+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}