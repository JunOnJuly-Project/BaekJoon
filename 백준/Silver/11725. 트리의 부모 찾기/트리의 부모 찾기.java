import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        List<List<Integer>> tree = new ArrayList<>();
        for (int i=0;i<N+1;i++) tree.add(new ArrayList<>());
        for (int i=0;i<N-1;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a, b;
    		a = Integer.parseInt(st.nextToken());
    		b = Integer.parseInt(st.nextToken());
    		
    		tree.get(a).add(b);
    		tree.get(b).add(a);
        }
        
        Deque<Integer> dq = new LinkedList<>();
        int[] visited = new int[N+1];
        
        dq.add(1);
        visited[1] = -1;
        while (!dq.isEmpty()) {
        	int now = dq.pollFirst();
        	
        	for (int next : tree.get(now)) {
        		if (visited[next]==0) {
        			visited[next] = now;
        			dq.addLast(next);
        		}
        	}
        }
        
        for (int i=2;i<N+1;i++) bw.write(visited[i] + "\n");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}