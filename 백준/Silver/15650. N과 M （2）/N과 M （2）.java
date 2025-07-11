import java.io.*;
import java.util.*;


public class Main {
	public List<List<Integer>> combinations(int N, int M, int[] nums, int curIdx, int cnt, List<Integer> candid) throws Exception {
		List<List<Integer>> results = new ArrayList<>();
		
		if (cnt==M) {
			results.add(candid);
			return results;
		}
		
		if (curIdx>=N) {
			return results;
		}
		
		candid.add(nums[curIdx]);
		results.addAll(combinations(N, M, nums, curIdx+1, cnt+1, new ArrayList<>(candid)));
		candid.remove(candid.size()-1);
		results.addAll(combinations(N, M, nums, curIdx+1, cnt, new ArrayList<>(candid)));
		
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
        Arrays.setAll(nums, i->i+1);
        
        List<List<Integer>> results = combinations(N, M, nums, 0, 0, new ArrayList<Integer>());
        
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