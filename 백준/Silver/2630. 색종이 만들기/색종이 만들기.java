import java.io.*;
import java.util.*;

public class Main {
	// 입력받은 보드
	int[][] board;
	
	// 영역을 분할해가는 재귀 함수
	public int[] reculSol(int[][] board, int si, int ei, int sj, int ej) {
		// 현재 전체 보드가 white 면 state 0
		// 현재 전체 보드가 blue 면 state 1
		// 초기값은 -1 == 정해지지 않음
		int state = -1;
		// 현재 보드에서 구분된 각 보드의 수
		int white = 0;
		int blue = 0;
		
		// 현재 범위 탐색
		for (int i = si; i < ei; i++) {
			for (int j = sj; j < ej; j++) {
				// 아직 state 가 정해지지 않았으면
				if (state == -1) {
					// 첫 색의 state 로 정함
					state = board[i][j];
				}
				
				// state 가 정해져 있고 다음 칸의 색이 일치하지 않으면
				// 보드가 하나의 색으로 정해지지 않았음
				else if (state != board[i][j]) {
					// 다음 분할 기준
					int mi = (si + ei) / 2;
					int mj = (sj + ej) / 2;
					
					// 순회
					int[] is = new int[] {si, mi, ei};
					int[] js = new int[] {sj, mj, ej};
					
					for (int k = 0; k < 2; k++) {
						for (int l = 0; l < 2; l++) {
							// 시작 - 중간 / 중간 - 끝
							int[] wb = reculSol(board, is[k], is[k + 1], js[l], js[l + 1]);
							// 리턴값은 쪼개진 블럭의 흰색 / 파란색 조각 수
							// 각자 누적
							white += wb[0];
							blue += wb[1];
						}
					}
					
					// 현재 보드의 조각 합 리턴
					return new int[] {white, blue};
				}
			}
		}
		
		// 여기까지 왔다면 현재 범위의 보드는 하나의 색이라는 뜻
		// state 에 따라 맞는 색에 개수 더해주기
		if (state==0) white += 1;
		else blue += 1;
		
		// 현재 보드의 조각 수들 리턴
		return new int[] {white, blue};
	}
	
    public void solution() throws Exception {
    	// 버퍼, 토큰화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        // 입력
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        
        for (int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0;j<N;j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        // 보드 분할 결과
        int[] result = reculSol(board, 0, N, 0, N);
        
        // 출력
        bw.write(result[0] + "\n");
        bw.write(result[1] + "\n");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}