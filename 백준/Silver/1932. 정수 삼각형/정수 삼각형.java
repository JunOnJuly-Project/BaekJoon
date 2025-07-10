import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n;
        n = Integer.parseInt(br.readLine());
        
        List<List<Integer>> tri = new ArrayList<>();
        for (int i=0;i<n;i++) tri.add(new ArrayList<>());
        	
        for (int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0;j<i+1;j++) tri.get(i).add(Integer.parseInt(st.nextToken()));
        }
        

        for (int i=1;i<n;i++) {
        	for (int j=0;j<i+1;j++) {
        		int left = 0;
        		int right = 0;
        		
    			if (j==0) {
    				right = tri.get(i-1).get(j) + tri.get(i).get(j);
    				tri.get(i).set(j, right);
    			}
    			
    			else if (j==i) {
    				left = tri.get(i-1).get(j-1) + tri.get(i).get(j);
    				tri.get(i).set(j, left);
        		}
    			
    			else {
    				right = tri.get(i-1).get(j) + tri.get(i).get(j);
    				left = tri.get(i-1).get(j-1) + tri.get(i).get(j);
    				
    				tri.get(i).set(j, left>right ? left : right);
    			}
        	}
        }
        
        int max = 0;
        int candid;
        for (int i=0;i<n;i++) max = (candid = tri.get(n-1).get(i))>max ? candid : max;
        
        
        bw.write(max+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}