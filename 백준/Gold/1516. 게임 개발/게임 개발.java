import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    int N = Integer.parseInt(br.readLine());
	    
	    // graph[현재 노드] = [다음 노드들]
	    List<List<Integer>> graph = new ArrayList<>();
	    // topol[현재 노드] = [이전 노드들]
	    List<Set<Integer>> topol = new ArrayList<>();
	    for (int i = 0; i < N + 1; i++) {
	    	graph.add(new ArrayList<>());
	    	// 빠르게 제거하기 위해 set 사용
	    	topol.add(new HashSet<>());
	    }
	    
	    int[] times = new int[N + 1];
	    
	    for (int i = 0; i < N; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	
	    	times[i + 1] = Integer.parseInt(st.nextToken());
	    	
	    	int require;
	    	while ((require = Integer.parseInt(st.nextToken())) != -1) {
	    		topol.get(i + 1).add(require);
	    		graph.get(require).add(i + 1);
	    	}
	    }
	    
	    int[] minTimes = new int[N + 1];
	    
	    Deque<int[]> queue = new LinkedList<>();
	    // 선행 건물이 없는 경우를 삽입
	    for (int i = 1; i < N + 1; i++) {
	    	if (topol.get(i).isEmpty() == true) {
	    		queue.add(new int[] {i, times[i]});
	    		minTimes[i] = times[i];
	    	}
	    }
	    
    	while (queue.isEmpty() != true) {
    		int[] curArr = queue.pollFirst();
    		int curBuild = curArr[0];
    		int curTime = curArr[1];
    		
    		for (int nextBuild : graph.get(curBuild)) {
    			int nextTime = curTime + times[nextBuild];
    			topol.get(nextBuild).remove(curBuild);
    			minTimes[nextBuild] = Math.max(minTimes[nextBuild], nextTime);
    			
    			if (topol.get(nextBuild).isEmpty() == true) {
    				queue.add(new int[] {nextBuild, minTimes[nextBuild]});
    			}
    		}
    	}
	    
    	for (int i = 1; i < N + 1; i++) {
    		bw.write(minTimes[i] + "\n");
    	}
        
	    // 출력
	    br.close();
	    bw.flush();
	    bw.close();
	  }
	  
	  public static void main(String[] args) throws Exception {
	      new Main().solution();
	  }
}