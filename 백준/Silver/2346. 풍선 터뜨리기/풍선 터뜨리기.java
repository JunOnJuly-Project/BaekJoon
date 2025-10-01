import java.io.*;
import java.util.*;

public class Main {
	Deque<int[]> rotateBalloon(Deque<int[]> balloons, boolean dir) {
		if (dir) {
			balloons.addLast(balloons.pollFirst());
		}
		
		else {
			balloons.addFirst(balloons.pollLast());
		}
		
		return balloons;
	}
	
	public void solution() throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<int[]> balloons = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			balloons.add(new int[] {i + 1, Integer.parseInt(st.nextToken())});
		}
		
		while (balloons.isEmpty() == false) {
			int[] cur = balloons.pollFirst();
			int idx = cur[0];
			int move = cur[1];
			
			bw.write(idx + " ");
			
			if (balloons.isEmpty()) {
				break;
			}
			
			boolean dir = move > 0 ? true : false;
			move = (dir ? move - 1 : -move) % balloons.size();
			
			for (int j = 0; j < move; j++) {
				balloons = rotateBalloon(balloons, dir);
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