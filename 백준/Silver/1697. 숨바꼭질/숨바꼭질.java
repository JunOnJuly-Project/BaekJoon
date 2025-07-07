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
        
        boolean[] visited = new boolean[100001];
        visited[N] = true;
        
        Deque<int[]> dq = new LinkedList<>();
        dq.addLast(new int[] {0, N});
        
        while(!dq.isEmpty()) {
        	int[] ns = dq.pollFirst();
        	int t = ns[0];
        	int n = ns[1];

        	if (n==K) {
        		bw.write(t+"");
        		break;
        	}
        	
        	if (n<=50000 && !visited[n*2]) {
        		dq.addLast(new int[] {t+1, n*2});
        		visited[n*2] = true;
        	}
        	
        	if (n<K && !visited[n+1]) {
        		dq.addLast(new int[] {t+1, n+1});
        		visited[n+1] = true;
        	}
        	
        	if (n>0 && !visited[n-1]) {
        		dq.addLast(new int[] {t+1, n-1});
        		visited[n-1] = true;
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