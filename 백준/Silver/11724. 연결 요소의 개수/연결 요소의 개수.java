import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        List<Integer>[] tree = new ArrayList[N+1];
        for (int i=0;i<N+1;i++) tree[i] = new ArrayList<>();
        
        for (int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int u, v;
        	u = Integer.parseInt(st.nextToken());
        	v = Integer.parseInt(st.nextToken());
        	
        	tree[u].add(v);
        	tree[v].add(u);
        }
        
        boolean[] visited = new boolean[N+1];
        
        int cnt = 0;
        Deque<Integer> dq = new LinkedList<>();
        while (true) {
        	if (dq.isEmpty()) {
	        	for (int i=1;i<N+1;i++) {
	        		if (!visited[i]) {
	        			visited[i] = true;
	        			dq.addLast(i);
	        			cnt += 1;
	        			break;
	        		}
	        	}
        	}
        	
        	if (dq.isEmpty()) break;
        	
        	int now = dq.pollFirst();
        	for (int next : tree[now]) {
        		if (!visited[next]) {
        			visited[next] = true;
        			dq.addLast(next);
        		}
        	}
        }
        
        bw.write(cnt+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}