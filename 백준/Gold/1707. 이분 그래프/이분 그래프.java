import java.io.*;
import java.util.*;

public class Main {
	public int V;
	public int E;
	public List<Set<Integer>> graph;
	
	public boolean isBinaryGraph() throws Exception {
    	int[] classifyBinary = new int[V + 1];
        Deque<Integer> dq = new LinkedList<>();
        while (true) {
        	// 모든 노드가 연결되어 있다는 보장이 없다.
        	for (int i = 1; i < V + 1; i++) {
        		if (classifyBinary[i] == 0) {
        			classifyBinary[i] = 1;
        			dq.add(i);
        			break;
        		}
        	}
        	
        	if (dq.isEmpty() == true) {
        		break;
        	}
        	
        	while (dq.isEmpty() != true) {
        		int cur = dq.pollFirst();
        		
        		for (int next : graph.get(cur)) {
        			if (classifyBinary[next] == 0) {
        				classifyBinary[next] = classifyBinary[cur] * -1;
        				dq.add(next);
        			}
        			
        			else if (classifyBinary[next] == classifyBinary[cur]) {
        				return false;
        			}
        		}
        	}
        }
        
        return true;
	}
	
	public void solution() throws Exception {
		// 입력
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
        int K = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < K; tc++) {
        	st = new StringTokenizer(br.readLine());

        	V = Integer.parseInt(st.nextToken());
        	E = Integer.parseInt(st.nextToken());
        	
        	graph = new ArrayList<>();
        	// 중복되는 엣지가 들어오지 않는다는 보장이 없다.
        	for (int i = 0; i < V + 1; i++) {
        		graph.add(new HashSet<>());
        	}
	        
        	for (int i = 0; i < E; i++) {
        		st = new StringTokenizer(br.readLine());
        		
        		int u, v;
        		u = Integer.parseInt(st.nextToken());
        		v = Integer.parseInt(st.nextToken());
        		
        		graph.get(u).add(v);
        		graph.get(v).add(u);
        	}
        	
        	boolean result = isBinaryGraph();
        	
        	if (result == true) {
        		bw.write("YES\n");
        	}
        	
        	else {
        		bw.write("NO\n");
        	}
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