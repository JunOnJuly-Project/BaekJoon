import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map<Integer, Deque<Integer>> dishesNeeds = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < k; j++) {
				int A =  Integer.parseInt(st.nextToken());
				if (dishesNeeds.containsKey(A) == false) {
					dishesNeeds.put(A, new LinkedList<>());
				}
				
				dishesNeeds.get(A).add(i);
			}
		}
		
		int[] result = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			if (dishesNeeds.containsKey(target) && dishesNeeds.get(target).isEmpty() == false) {
				int costomer = dishesNeeds.get(target).pollFirst();
				result[costomer] += 1;
			}			
		}
		
		for (int cnt : result) {
			bw.write(cnt + " ");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}