import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 버퍼, 토큰화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        // 입력
        int N = Integer.parseInt(br.readLine());
        // 경로 기록 어레이
        int[] visited = new int[1000001];
        // DFS 를 위한 데크
        Deque<int[]> queue = new LinkedList<>();
        // 초기값은 {N, 0}
        queue.add(new int[] {N, 0});
        // 순회
        while (queue.isEmpty() != true) {
        	// 최상위 추출
        	int[] cur = queue.pollFirst();
        	// 현재 수
        	int curNum = cur[0];
        	// 현재 카운트
        	int curCnt = cur[1];
        	
        	// 현재 수가 1이면
        	if (curNum == 1) {
        		// 출력
        		bw.write(curCnt + "\n");
        		break;
        	}
        	
        	// 다음 카운트
        	int nextCnt = curCnt + 1;
        	// 3 의 배수면
        	if (curNum % 3 == 0) {
        		// 다음 수
        		int nextNum = curNum / 3;
        		// 다음 수의 경로가 존재하지 않으면
        		// -> 아직 다음 수까지의 최단 경로가 존재하지 않으므로
        		if (visited[nextNum] == 0) {
        			// 큐에 추가
        			queue.add(new int[] {nextNum, nextCnt});
        			// 다음 수 까지 최단경로 등록
        			visited[nextNum] = curNum;
        		}
        	}
        	
        	// 2의 배수면
        	if (curNum % 2 == 0) {
        		// 다음 수
        		int nextNum = curNum / 2;
        		// 다음 수의 경로가 존재하지 않으면
        		// -> 아직 다음 수까지의 최단 경로가 존재하지 않으므로
        		if (visited[nextNum] == 0) {
        			// 큐에 추가
        			queue.add(new int[] {nextNum, nextCnt});
        			// 다음 수 까지 최단경로 등록
        			visited[nextNum] = curNum;
        		}
        	}
        	
        	// -1
        	// 다음 수
    		int nextNum = curNum - 1;
    		// 다음 수의 경로가 존재하지 않으면
    		// -> 아직 다음 수까지의 최단 경로가 존재하지 않으므로
    		if (visited[nextNum] == 0) {
    			// 큐에 추가
    			queue.add(new int[] {nextNum, nextCnt});
    			// 다음 수 까지 최단경로 등록
    			visited[nextNum] = curNum;
    		}
        }
        
        // 경로 추적
        Stack<Integer> stk = new Stack<Integer>();
        // 시작점은 1
        stk.add(1);
        // 순회 시작
        // 현재 수
        int curNum;
        while ((curNum = stk.peek()) != N) {
        	// 다음 수 스택에 추가
        	stk.add(visited[curNum]);
        }
        
        // 뒤에서 부터 출력
        while (stk.isEmpty() != true) {
        	bw.write(stk.pop() + " ");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}