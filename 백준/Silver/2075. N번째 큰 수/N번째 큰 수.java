import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Deque<Integer>> pq = new PriorityQueue<>((a, b) -> {
			return b.peekFirst() - a.peekFirst();
		});
		
		List<Deque<Integer>> nums = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			nums.add(new LinkedList<>());
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				nums.get(j).addFirst(Integer.parseInt(st.nextToken()));
			}
		}
		
		pq.addAll(nums);
		
		for (int i = 0; i < N; i++) {
			Deque<Integer> poll = pq.poll();
			int pollPoll = poll.pollFirst();
			
			if (i == N - 1) {
				bw.write(pollPoll + "");				
			}
			
			if (poll.isEmpty() == false) {
				pq.add(poll);				
			}
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}