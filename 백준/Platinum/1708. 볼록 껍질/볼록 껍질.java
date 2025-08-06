import java.util.*;
import java.io.*;

class Point{
	int x;
	int y;
	
	Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public Point originPoint;
	
	public int ccw(Point a, Point b, Point c) {
		Point[] points = new Point[] {a, b, c, a};
		
		long result = 0;
		for (int i = 0; i < 3; i++) {
			result += points[i].x * points[i+1].y;
			result -= points[i+1].x * points[i].y;
		}
		
		return result == 0 ? 0 : result > 0 ? 1 : -1;
	}
	
	public long calDist(Point a, Point b) {
		long dX = a.x - b.x;
		long dY = a.y - b.y;
		
		return dX * dX + dY * dY;
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Point[] points = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(points, (a, b) -> {
			if (a.x == b.x) {
				return a.y - b.y;
			}
			
			else {
				return a.x - b.x;
			}
		});
		
		originPoint = points[0];
		
		Arrays.sort(points, (a, b) -> {
			if (ccw(originPoint, a, b) == 0) {
				return Long.compare(calDist(originPoint, a), calDist(originPoint, b));		
			}
			
			else {
				return -ccw(originPoint, a, b);
			}
		});
		
		int pointIndex = 0;
		Stack<Point> stk = new Stack<>();
		while (pointIndex < points.length) {
			if (stk.size() < 2) {
				stk.add(points[pointIndex++]);
				continue;
			}
			
			while (stk.size() >= 2 && ccw(stk.get(stk.size()-2), stk.get(stk.size()-1), points[pointIndex]) <= 0) {
				stk.pop();
			}
			
			stk.add(points[pointIndex++]);
		}
		
		bw.write(stk.size() + "");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}