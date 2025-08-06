import java.util.*;
import java.io.*;

public class Main {
	public void solution() throws Exception {
        // 버퍼 관련
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 토큰화
        StringTokenizer st;
		
        // 입력
		int N = Integer.parseInt(br.readLine());
        int[][] dists = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) dists[i][j] = Integer.parseInt(st.nextToken());
		}
		
        // 방문 체크 겸 최단거리
        // visited[i][j] = 현재 i 노드에 있고,
        //                 지나온 노드에 대한 정보가 j 일 때 거리 최솟값
        // >> j 의 값을 이진화 했을 때,  1 : 지나온 노드
        //                            0 : 아직 지나오지 않은 노드
        // 즉 visited 는 총 노드의 개수 N 행
        //              모든 노드를 지나올 수 있는 경우의 수 1<<N == 2^N 열
		int[][] visited = new int[N][1 << N];
        // 최솟값 비교를 위해 최댓값으로 초기화
		for (int i = 0; i < N; i++) Arrays.fill(visited[i], Integer.MAX_VALUE/2);
		// 현재 i 에 있고 아무 노드도 지나지 않은 경우는 없으므로 0 으로 초기화
        for (int i = 0; i < N; i++) visited[i][0] = 0;
        // 현재 i 에 있고 i 를 지난 경우 시작점이므로 0 으로 초기화
		for (int i = 0; i < N; i++) visited[i][1 << i] = 0;
        
        // BFS 를 위한 데크 선언
		Deque<int[]> dq = new LinkedList<>();
        // 어느 노드에서 시작해도 같다
        // 그냥 0 에서 시작
        // dq[i] = {현재 위치한 노드, 현재 누적거리, 방문했던 노드 정보}
		dq.add(new int[] {0, 0, 1 << 0});			
        
        // 데크가 빌 때 까지 == 더이상 순회할 노드가 없을 때 까지
		while (dq.isEmpty() != true) {
            // 맨 앞 뽑기
			int[] cur = dq.pollFirst();
			int curNode = cur[0];
			int curDist = cur[1];
			int curVisitedNode = cur[2];
			
            // 현재 누적 거리가 기록된 최단거리보다 길면
            // 최단거리가 될 수 없으므로 패스
			if (curDist > visited[curNode][curVisitedNode]) {
				continue;
			}
			
            // 모든 노드 순회
			for (int nextNode = 0; nextNode < N; nextNode++) {
                // 다음 노드와 연결되어 있고 다음 노드를 방문한적이 없을 때
                // -> (A & (1 << B)) == 0)
                //    는 일반적으로 A 의 B 번째 비트가 1 인지 체크할 때 사용
				if (dists[curNode][nextNode] != 0 && (curVisitedNode & (1 << nextNode)) == 0) {
					// 다음 노드까지 누적 거리 = 현재 누적거리 + 노드간 거리
                    int nextDist = curDist+dists[curNode][nextNode];
                    // 다음 방문 정보 = 현재 방문 정보 + 현재 노드
                    // -> A | (1 << B)
                    //    는 일반적으로 A 의 B 번쨰 비트를 1 로 바꿀 때 사용
					int nextVisitedNode = curVisitedNode | (1 << nextNode);
                    
                    // 다음 노드까지 누적 거리가 기록된 최단거리보다 짧으면
					if (nextDist < visited[nextNode][nextVisitedNode]){
						// 최단거리 기록
                        visited[nextNode][nextVisitedNode] = nextDist;
						// 데크에 삽입
                        dq.add(new int[] {nextNode, nextDist, nextVisitedNode});
					}
				}
			}
		}
		
        // 최솟값 비교를 위한 최댓값 할당
		int min = Integer.MAX_VALUE;
		
        // 0 에서 시작해서 i 노드에서 끝났을 경우를 모두 탐색
		for (int i = 1; i < N; i++) {
            // i 노드에서 0 노드로 돌아와야 하기 때문에
            // 돌아올 수 없으면 고려하지 않음
			if (dists[i][0] == 0) {
				continue;
			}
			
            // 최솟값 갱신
            // -> i 노드에서 모든 노드를 거쳐왔을 때 누적 거리
            //    + i 노드에서 0 노드로 돌아오는 거리
			min = Math.min(min, visited[i][(1<<N)-1] + dists[i][0]);
		}
		
        // 버퍼 입력 및 출력
		bw.write(min + "");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}