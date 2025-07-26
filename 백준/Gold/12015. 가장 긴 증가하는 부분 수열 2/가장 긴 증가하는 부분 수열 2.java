import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());
        
        int[] idxs = new int[N];
        idxs[0] = 1;
        
        List<Integer> lis = new ArrayList<>(); 
        lis.add(A[0]);

        for (int i=1;i<N;i++) {
        	int a = A[i];
        	
        	if (a>lis.get(lis.size()-1)) {
    			lis.add(a);
    			idxs[i] = lis.size();
    			continue;
        	}
        	
        	int bSearch = Collections.binarySearch(lis, a);	
    		int posIdx = bSearch>=0 ? bSearch : -bSearch-1;
    		
			idxs[i] = posIdx+1;
			lis.set(posIdx, a);
        }
        
        bw.write(lis.size() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}