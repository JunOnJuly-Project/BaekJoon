import java.util.*;
import java.io.*;

public class Main {
	public void solution() throws Exception {
		// 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        // 톱니의 상태를 저장
        List<Cog> cogs = new ArrayList<>();
        for (int i = 0; i < T; i++) {
        	List<Integer> cog = new ArrayList<>();
        	
        	String input = br.readLine();
        	for (int j = 0; j < input.length(); j++) {
        		cog.add(input.charAt(j) - '0');        		
        	}
        	
        	cogs.add(new Cog(cog, 0));
        }
        
        // 입력
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
        	st = new StringTokenizer(br.readLine());
        	// 톱니바퀴 번호, 방향
        	int n, d;
        	n = Integer.parseInt(st.nextToken()) - 1;
        	d = Integer.parseInt(st.nextToken());
        	
        	// 투포인터
        	int r, l;
        	l = n - 1;
        	r = n + 1;
        	
        	// 시작 톱니 세팅
        	cogs.get(n).setWillRotate(d);
        	// 순회
        	while (l >= 0 || r < T) {
        		// l 이 범위 내고
        		if (l >= 0) {
        			/*
        			 *  왼쪽 톱니바퀴의 2번 톱니와
        			 *  오른쪽 톱니바퀴의 6번 톱니가 다르면
        			 *  오른쪽 톱니바퀴 반대방향으로
        			 *  왼쪽 톱니바퀴가 회전할것
        			 */
        			if (cogs.get(l).getState().get(2) != cogs.get(l + 1).getState().get(6)) {
        				cogs.get(l).setWillRotate(cogs.get(l + 1).getWillRotate() * -1);
        			}
        			// 다음 톱니
        			l -= 1;
        		}
        		// r 이 범위 내고
        		if (r < T) {
        			/*
        			 *  오른쪽쪽 톱니바퀴의 6번 톱니와
        			 *  왼쪽 톱니바퀴의 2번 톱니가 다르면
        			 *  왼쪽 톱니바퀴 반대방향으로
        			 *  오른쪽 톱니바퀴가 회전할것
        			 */
        			if (cogs.get(r).getState().get(6) != cogs.get(r - 1).getState().get(2)) {
        				cogs.get(r).setWillRotate(cogs.get(r - 1).getWillRotate() * -1);
        			}
        			// 다음 톱니
        			r += 1;
        		}
        	}
        	
        	// 전체 톱니 회전 및 회전 방향 초기화
        	for (Cog cog : cogs) {
        		cog.rotate();
        		cog.setWillRotate(0);
        	}
        }
        
        // 카운트
        int cnt = 0;
        // 12 시가 s 극인지 카운트
        for (Cog cog : cogs) {
        	if (cog.getState().get(0) == 1) {
        		cnt += 1;
        	}
        }
        
        bw.write(cnt + "");
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}

class Cog {
	private List<Integer> state;
	private int willRotate;
	

	public List<Integer> getState() {
		return state;
	}

	public void setWillRotate(int willRotate) {
		this.willRotate = willRotate;
	}
	
	public int getWillRotate() {
		return this.willRotate;
	}

	public Cog(List<Integer> state, int willRotate) {
		this.state = state;
		this.willRotate = willRotate;
	}
	
	public void rotate() {
		Collections.rotate(state, willRotate);
		willRotate = 0;
	}
}