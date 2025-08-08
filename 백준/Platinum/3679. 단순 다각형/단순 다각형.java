import java.util.*;
import java.io.*;

// 위치 정보를 담은 클래스
class Point{
	int x;
	int y;
	int index;
	
	Point (int x, int y, int index) {
		this.x = x;
		this.y = y;
		this.index = index;
	}
}

public class Main {
	// 반시계 방향으로 정렬을 시작할 때
	// 시작점이 될 점
	public Point originPoint;
	
	// 외적 (반시계 방향 판별식 / 신발끈 공식)
	public int ccw(Point a, Point b, Point c) {
		Point[] points = new Point[] {a, b, c, a};
		
		long result = 0;
		for (int i = 0; i < 3; i++) {
			result += points[i].x * points[i+1].y;
			result -= points[i+1].x * points[i].y;
		}
		
		// 결과를 압축, 부호만 리턴
		return result == 0 ? 0 : result > 0 ? 1 : -1;
	}
	
	// 두 점의 거리 계산
	// 거리 비교만 할거라 굳이 제곱근 계산은 안해도 됨
	public long calDist(Point a, Point b) {
		long dX = a.x - b.x;
		long dY = a.y - b.y;
		
		return dX * dX + dY * dY;
	}
	
	public void solution() throws Exception {
		// 버퍼, 토큰
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 입력
		int c = Integer.parseInt(br.readLine());
		
		for (int C=0 ; C<c; C++) {
			st = new StringTokenizer(br.readLine());
			// 점의 수
			int n = Integer.parseInt(st.nextToken());
			// 위치 정보가 담긴 어레이
			Point[] points = new Point[n];
			
			for (int i = 0; i < n; i++) {
				points[i] = new Point(
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					i
					);
			}
			
			// x축, y축을 대상으로 오름차순 정렬
			// x, y 축 정렬을 진행하는 이유
			// (1) 점들의 집합에서 최외곽에 있는 점은
			//     무조건 볼록껍질에 포함되므로 시작점으로 잡음
			//     즉, 정렬 후에 첫 점을 시작점으로 잡기 위해
			// (2) x, y 를 특정 기준으로 정렬하면
			//     후에 시계방향 혹은 반시계방향 정렬을 할 때
			//     좀 더 효율적인 진행이 가능하기 때문
			// 즉 꼭 정렬 기준이 오름차순일 필요는 없다.
			Arrays.sort(points, (a, b) -> {
				if (a.x == b.x) {
					return a.y - b.y;
				}
				
				else {
					return a.x - b.x;
				}
			});
			
			// 최외곽 포인트, 볼록 껍질에 속한 점 중 하나, 시작점
			originPoint = points[0];
			
			// 반시계 방향으로 정렬
			Arrays.sort(points, (a, b) -> {
				// 세 점이 한 직선위에 있으면
				// 가까운 점이 우선
				if (ccw(originPoint, a, b) == 0) {
					return Long.compare(calDist(originPoint, a), calDist(originPoint, b));		
				}
				
				// 세 점이 반시계방향이면 현재 순서 그대로
				else {
					return -ccw(originPoint, a, b);
				}
			});
			
			// 시작점과 마지막 점들이 직선인 경우 재정렬해야함
			int s = points.length - 1;
			while (ccw(originPoint, points[s], points[s - 1]) == 0) {
				s -= 1;
			}
			
			Arrays.sort(points, s, points.length, (a, b) -> {
				return Long.compare(calDist(originPoint, b), calDist(originPoint, a));
			});
			
			for (int i = 0; i < points.length; i++) {
				bw.write(points[i].index + "");
				if (i != points.length - 1) {
					bw.write(" ");
				}
			}
			
			if (C != c - 1) {
				bw.write("\n");
			}
		}
		
		// 출력
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}