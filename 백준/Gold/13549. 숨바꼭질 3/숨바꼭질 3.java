import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N, K;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        PriorityQueue<int[]> hq = new PriorityQueue<int[]>((a, b)->a[0]-b[0]);
        hq.add(new int[] {0, N});
        
        int[] visited = new int[100001];
        Arrays.setAll(visited, i->Integer.MAX_VALUE);
        while (!hq.isEmpty()) {
        	int[] curArr = hq.poll();
        	int curTime = curArr[0];
        	int curIdx = curArr[1];
        	
        	if (curIdx==K) {
        		bw.write(curTime+"");
        		break;
        	}
        	
        	if (curTime>visited[curIdx]) continue;
        	
        	if (curIdx>K && curTime<visited[curIdx-1]) {
        		visited[curIdx-1] = curTime+1;
        		hq.add(new int[] {curTime+1, curIdx-1});
    		}
        	
        	else {
        		if (curIdx*2<=100000 && curTime<visited[curIdx*2]) {
    				visited[curIdx*2] = curTime;
    				hq.add(new int[] {curTime, curIdx*2});
        		}
        		
        		if (curIdx>0 && curTime+1<visited[curIdx-1]) {
        			visited[curIdx-1] = curTime+1;
        			hq.add(new int[] {curTime+1, curIdx-1});
        		}
        		
        		if (curTime+1<visited[curIdx+1]) {
	        		visited[curIdx+1] = curTime+1;
	        		hq.add(new int[] {curTime+1, curIdx+1});
        		}
        	}
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}