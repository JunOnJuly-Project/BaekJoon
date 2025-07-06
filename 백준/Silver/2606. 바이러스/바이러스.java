import java.io.*;
import java.util.*;


public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        List<Set<Integer>> tree = new ArrayList<>();
        for (int i=0;i<N+1;i++) tree.add(new HashSet<Integer>());
        
        for (int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int n1, n2;
        	n1 = Integer.parseInt(st.nextToken());
        	n2 = Integer.parseInt(st.nextToken());
        	
        	tree.get(n1).add(n2);
        	tree.get(n2).add(n1);
        }
        
        Boolean[] visited = new Boolean[N+1];
        Arrays.setAll(visited, i->true);
        visited[1] = false;
        
        Deque<Integer> dq = new LinkedList<>();
        dq.addLast(1);
        
        int cnt = 0;
        while(!dq.isEmpty()) {
        	int now = dq.pollFirst();
        	for (int next : tree.get(now)) {
        		if (visited[next]) {
        			visited[next] = false;
        			dq.addLast(next);
        			cnt += 1;
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