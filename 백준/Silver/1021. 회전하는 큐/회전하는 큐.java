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
		
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			dq.add(i + 1);
		}
		
		int result = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			Deque<Integer> leftDq = new LinkedList<>(dq);
			Deque<Integer> rightDq = new LinkedList<>(dq);
			
			while (true) {
				if (leftDq.peekFirst() == target) {
					leftDq.pollFirst();
					dq = leftDq;
					break;
				}
				
				if (rightDq.peekFirst() == target) {
					rightDq.pollFirst();
					dq = rightDq;
					break;
				}
				
				leftDq.addLast(leftDq.pollFirst());
				rightDq.addFirst(rightDq.pollLast());
				result += 1;
			}
		}
		
		bw.write(result + "");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}