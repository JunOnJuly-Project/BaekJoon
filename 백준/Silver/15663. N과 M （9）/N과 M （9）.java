import java.io.*;
import java.util.*;


public class Main {
	public List<List<Integer>> combinations(int N, int M, int[] nums, int cnt, List<Integer> candid, boolean visited[]) throws Exception {
		List<List<Integer>> results = new ArrayList<>();
		
		if (cnt==M) {
			results.add(candid);
			return results;
		}

		for (int i=0;i<N;i++) {
			if (!visited[i] && !(i>0 && nums[i]==nums[i-1] && !visited[i-1])) {
				visited[i] = true;
				
				candid.add(nums[i]);
				List<List<Integer>> candids = combinations(N, M, nums, cnt+1, new ArrayList<>(candid), visited);
				results.addAll(candids);
				candid.remove(candid.size()-1);

				visited[i] = false;
			}
		}
		
		return results;
	}
	
	
	
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);
        
        List<List<Integer>> results = combinations(N, M, nums, 0, new ArrayList<>(), new boolean[N]);
        
        for (List<Integer> result : results) {
        	for (Integer num : result) bw.write(num + " ");
        	bw.write("\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}